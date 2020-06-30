package com.training;

import com.training.utils.Tuple;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements the log lines sorting problem:
 *
 * Input is a list of logLines <code>List<String></code> where each line is a
 * space separated string which always start with an alpha numeric string
 * followed by either integers or words never both.
 *
 * All the logLines with words need to be sorted alphabetically.
 * If two lines match, they need to be sorted based on the alpha numeric string.
 * The lines with integers need to be kept in the same order they are processed in.
 *
 * The returned list should have the logLines with words at the top (sorted)
 * and the log lines with the integer under them.
 *
 * Time to solve: This was solve with a relaxed limit, and approximately took 1 hr 30 min
 * with coding, testing and documentation.
 */
public class LogSortingProblem {

    // Driver program
    public static void main(String[] args) {
        List<String> logLines = Arrays.asList(
                "abc123 zoo",
                "abc123 hola",
                "ab99 99 100",
                "aba123 fox jump over",
                "abcd124 77 100"
        );

        sort(logLines);

        System.out.println(logLines);
    }

    /**
     * Sorts the log lines in lexicographical order.
     * Two lines are compared using the following logic:
     *
     * Both lines are INTEGERS lines:
     *   They are considered equal. Also, since java's list sorting algorithm
     *   is a stable sort, it will guarantee INTEGER lines appear in the
     *   same order as they are in the original list.
     *
     * Both lines are WORDS lines:
     *   First, compare lines using the words.
     *   If found equal, compare using the alpha-numeric string
     *
     * One line is INTEGERS and the other is WORDS:
     *   INTEGERS line appear lexicographically lower than WORDS line (as per the requirement)
     *
     * @param logLines The log lines to be sorted
     */
    public static void sort(List<String> logLines) {

        List<Tuple> lineInfos = logLines.stream().map(l -> getLineInfo(l)).collect(Collectors.toList());

        lineInfos.sort((lineInfo1, lineInfo2) -> {
            // Detect if it's line of words or line of integers.

            String line1 = lineInfo1.get(0);
            LineType lineType1 = lineInfo1.get(1);
            String alphaNumeric1 = lineInfo1.get(2);
            int logLineStart1 = lineInfo1.get(3);

            String line2 = lineInfo2.get(0);
            LineType lineType2 = lineInfo2.get(1);
            String alphaNumeric2 = lineInfo2.get(2);
            int logLineStart2 = lineInfo2.get(3);

            if (lineType1 == lineType2) {
                if (lineType1 == LineType.INTEGERS) {
                    return 0; // Integer lines are not to be sorted
                }

                int comp = compare(line1, line2, logLineStart1, logLineStart2, line1.length(), line2.length());
                if (comp == 0) { // if lines are equal then compare them using alpha-numeric string
                    return alphaNumeric1.compareTo(alphaNumeric2);
                } else {
                    return comp;
                }
            }

            // Integer lines appear at the bottom
            return lineType1 == LineType.WORDS ? -1 : 1;
        });

        for (int i = 0; i < lineInfos.size(); i++) {
            logLines.set(i, lineInfos.get(i).get(0));
        }
    }

    /**
     * Compares two sub strings
     * @param str1 First String
     * @param str2 Second String
     * @param start1 Start index (inclusive) in first string
     * @param start2 End index (exclusive) in first string
     * @param end1 Start index (inclusive) in second string
     * @param end2 End index (exclusive) in second string
     * @return 0 if equals, -1 if lesser and 1 if greater
     */
    private static int compare(String str1, String str2, int start1, int start2, int end1, int end2) {
        if (start1 < 0 || start2 < 0 || end1 > str1.length() || end2 > str2.length() || start1 > end1 || start2 > end2) {
            System.out.println("str1: " + str1 + " str2: " + str2 + " start1: " + start1
                                       + " end1: " + end1 + " start2: " + start2
                                       + " end2: " + end2);
            throw new IndexOutOfBoundsException("Incorrect offsets supplied");
        }

        int len = Math.min(end1 - start1, end2 - start2);

        for (int i = 0; i < len; i++) {
            char c1 = str1.charAt(i + start1);
            char c2 = str2.charAt(i + start2);
            if (c1 != c2) {
                return c1 - c2;
            }
        }

        return (end1 - start1 - end2 + start2); // Difference in lengths of the two substrings
    }

    /**
     * This returns a tuple containing info about the log line.
     * The 0th element is the line itself
     * The 1st element is the {@link LineType}
     * The 2nd element is the alpha-numeric string from the line
     * The 3rd element is the index one past the end of alpha-numeric in the line
     * @param logLine The log line
     * @return A tuple containing info about the log line
     */
    private static Tuple getLineInfo(String logLine) {
        int beginIdx = 0;
        int endIdx;
        int logStart;

        endIdx = skipAlphabets(beginIdx, logLine);

        String alphaNumeric = logLine.substring(beginIdx, endIdx);

        endIdx = skipWhiteSpace(endIdx, logLine);

        beginIdx = endIdx;
        logStart = endIdx;

        endIdx = skipAlphabets(beginIdx, logLine);

        String firstSymbol = logLine.substring(beginIdx, endIdx);

        LineType lineType = isInteger(firstSymbol) ? LineType.INTEGERS : LineType.WORDS;

        return Tuple.of(logLine, lineType, alphaNumeric, logStart);
    }

    /**
     * Skips white space and returns the index pointing to either
     * the next non-space character or at <code>str.length()</code>
     * @param beginIndex the start index in {@code str}
     * @param str the string
     * @return index pointing to either the next non-space character or at <code>str.length</code>
     */
    private static int skipWhiteSpace(@Nonnegative int beginIndex, @Nonnull String str) {
        int cursor = beginIndex;
        while (cursor < str.length() && Character.isWhitespace(str.charAt(cursor))) {
            cursor++;
        }

        return cursor;
    }

    /**
     * Skips alphabets and returns the index pointing to either
     * the next white space character or at <code>str.length()</code>
     * @param beginIndex the start index in {@code str}
     * @param str the string
     * @return index pointing to either the next space character or at <code>str.length</code>
     */
    private static int skipAlphabets(@Nonnegative int beginIndex, @Nonnull String str) {
        int cursor = beginIndex;
        while (cursor < str.length() && (Character.isAlphabetic(str.charAt(cursor)) || Character.isDigit(str.charAt(cursor)))) {
            cursor++;
        }

        return cursor;
    }

    /**
     * @param str The string
     * @return {@code true} if the {@link String} {@code str} can be parsed into an integer, else {@code false}
     */
    private static boolean isInteger(@Nonnull String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Type of strings in the log {@code INTEGERS} or {@code WORDS}
     */
    private enum LineType {
        INTEGERS,
        WORDS
    }
}
