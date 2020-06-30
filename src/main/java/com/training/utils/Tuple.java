package com.training.utils;

import java.util.Arrays;

/**
 * A tuple is an immutable list of items. These items can be of
 * any type and don't require any type information to be supplied.
 * This class is to facilitate a certain way of returning multiple
 * associated values from a method. It may be used at places where
 * many methods require returning multiple values, which may
 * require creating a lot of class definitions for such return values.
 * This is also useful when prototyping or quick iterative coding
 * where the return values are not finalized.
 *
 * For example:
 *
 *   Method {@code foo()} wants to return 3 values, each of a
 *   different type: String, int and boolean
 *
 *   <pre>{@code
 *     ReturnValues foo() {
 *         .. do something ..
 *         return new ReturnValues(retVal1, retVal2, retVal3)
 *     }
 *   }</pre>
 *
 *   OR
 *
 *   <pre>{@code
 *     void foo(ReturnValues retVals) {
 *         .. do something ..
 *         retVals.setVal1(retVal1).setVal2(retVal2).setVal3(retVal3)
 *     }
 *   }</pre>
 *
 *   The above two cases would require to define a new class for
 *   each method according to its return values. This can bloat
 *   the code base with many such classes. Also, any change in
 *   method's return values would require an update to the
 *   encapsulating class.
 *
 *   Instead if Tuple is used:
 *
 *   <pre>{@code
 *     Tuple foo() {
 *         .. do something ..
 *         return Tuple.of(retVal1, retVal2, retVal3)
 *     }
 *   }</pre>
 *
 *   To read back values of from tuple:
 *
 *   <pre>{@code
 *     String retVal1 = tuple.get(0);
 *     int retVal2 = tuple.get(1);
 *     boolean retVal3 = tuple.get(2);
 *   }</pre>
 *
 *   Notice when items are inserted and fetched, their types
 *   are not specified. Types are determined by the compiler
 *   when get() is invoked based on the type it is going to
 *   be assigned to, so explicit type specification or
 *   type casts are not required.
 */
public class Tuple {
    private final Object[] items;

    public static final Tuple EMPTY = new Tuple(new Object[0]);

    private Tuple(Object[] items) {
        this.items = items;
    }

    /**
     * Returns the item at index {@code i} in the tuple.
     * Items are indexed stating at 0.
     * @param i Index of requested item
     * @param <T> Type of requested item
     * @return Item at index {@code i}
     */
    public <T> T get(int i) {
        try {
            return (T) items[i];
        } catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Index [" + i + "] out of bounds for the tuple");
        } catch (ClassCastException ex) {
            throw new ClassCastException("Item at index [" + i + "] is of type " + items[i].getClass().getCanonicalName());
        }
    }

    /**
     * @return The number of items in this tuple
     */
    public int size() {
        return items.length;
    }

    /**
     * @param items The items out of which tuple is to be made.
     * @return A tuple containing the items. If items is null or empty, then it returns an empty tuple
     */
    public static Tuple of(Object ...items) {
        if (items == null) {
            return EMPTY;
        }
        return new Tuple(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return Arrays.equals(items, tuple.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                       "items=" + Arrays.toString(items) +
                       '}';
    }
}
