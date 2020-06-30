package com.training;

import java.util.*;

/**
 * Question1
 *
 * e.g:
 * numFeatures: 4
 * topFeatures: 2
 * possibleFeatures=['waterproof', 'camera', 'screen', 'speaker']
 * numFeatureRequests: 3
 * featureRequests=['I want more waterproof capabilities in the new phones', 'I would like a better camera on my phone along with waterproof features', 'I would like a bigger screen on the new phones']
 *
 * You are given method with 5 params: int numFeatures, int topFeatures, List<String> possibleFeatures, int numFeatureRequests, List<String> featureRequests.
 *
 * numFeatures: The number of total features that we are looking to support.
 * topFeatures: The number of top Requested features we want to return.
 * possibleFeatures: The features we are looking to support
 * numFeatureRequests: The total number of feature request strings
 * featureRequests: Space separated string of feature requests.
 *
 * Go through the feature requests, see if any of the top features appear in the feature requests. If a feature appears in a featureRequest more than once it should only be counted once.
 * At the end we need to return the top x number of features as defined in topFeatures. If two features were requested the same number of times, return them in alphabetical order.
 * if the topFeatures is >= numFeatures return the entire list of features.
 *
 * Time to solve: 30 min (20 min to solve and 10 min to test and fix)
 */
public class TopFeaturesProblem {

    // Driver program
    public static void main(String[] args) {
        int numFeatures = 4;
        int topFeatures = 2;
        List<String> possibleFeatures = Arrays.asList("waterproof", "camera", "screen", "speaker");
        int numFeatureRequests = 3;
        List<String> featureRequests = Arrays.asList(
                "I want more waterproof capabilities in the new phones",
                "I would like a better camera on my phone along with waterproof features",
                "I would like a bigger screen on the new phones"
        );

        System.out.println(getTopRequestedFeatures(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests));
    }

    public static List<String> getTopRequestedFeatures(int numFeatures, int topFeatures,
            List<String> possibleFeatures, int numFeatureRequests, List<String> featureRequests) {

        if (topFeatures >= numFeatures) {
            return possibleFeatures;
        }

        PriorityQueue<FeatureAndFrequency> topFeaturesByFrequency = new PriorityQueue<>((f1, f2) -> {
            int comp = Integer.compare(f1.frequency, f2.frequency);
            if (comp == 0) {
                return f1.feature.compareTo(f2.feature);
            }

            return -comp;
        });

        Map<String, Integer> featureAndFrequencies = new HashMap<>();
        Set<String> possibleFeatureSet = new HashSet<>(possibleFeatures);

        Set<String> tempSet = new HashSet<>();

        featureRequests.forEach(f -> {
            tempSet.clear();
            String[] words = f.split("\\s+"); // split on white space.
            for (String word : words) {
                if (possibleFeatureSet.contains(word)) {
                    tempSet.add(word);
                }
            }

            for (String feature : tempSet) {
                Integer freq = featureAndFrequencies.get(feature);
                if (freq == null) {
                    featureAndFrequencies.put(feature, 1);
                } else {
                    featureAndFrequencies.put(feature, freq + 1);
                }
            }
        });

        for (Map.Entry<String, Integer> featureAndFrequency: featureAndFrequencies.entrySet()) {
            topFeaturesByFrequency.offer(new FeatureAndFrequency(featureAndFrequency.getKey(), featureAndFrequency.getValue()));
        }

        System.out.println(featureAndFrequencies);

        List<String> topRequestedFeatures = new ArrayList<>();

        for (int i = 0; i < topFeatures; i++) {
            FeatureAndFrequency featureAndFrequency = topFeaturesByFrequency.poll();
            topRequestedFeatures.add(featureAndFrequency.feature);
        }

        return topRequestedFeatures;
    }

    private static class FeatureAndFrequency {
        String feature;
        int frequency;

        public FeatureAndFrequency(String feature, int frequency) {
            this.feature = feature;
            this.frequency = frequency;
        }
    }
}
