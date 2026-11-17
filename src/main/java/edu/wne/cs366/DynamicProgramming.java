package edu.wne.cs366;

import java.util.List;
import java.util.Objects;

/**
 * CS366 Programming Assignment 03: Dynamic Programming.
 *
 * @author Your Name
 */
public final class DynamicProgramming {

    private DynamicProgramming() {
    }

    /** Result of the minimum-coin-change algorithm. */
    public record CoinChangeResult(int minimumCount, List<Integer> coins) {
        public CoinChangeResult {
            coins = List.copyOf(coins);
        }
    }

    /** Result of the simplified 0/1-knapsack algorithm. */
    public record KnapsackResult(int totalSize, int unusedCapacity,
                                 List<Integer> selectedIndices) {
        public KnapsackResult {
            selectedIndices = List.copyOf(selectedIndices);
        }
    }

    /**
     * Finds a minimum-cardinality multiset of denominations totaling amount.
     * Denominations may be reused. On a tie, the earlier denomination is used.
     *
     * @param denominations positive coin denominations in preference order
     * @param amount nonnegative target amount
     * @return minimum count and traceback coins, or count -1 and an empty list
     *         when the amount is impossible
     */
    public static CoinChangeResult minimumCoins(int[] denominations, int amount) {
        validatePositiveArray(denominations, "denominations");
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be nonnegative");
        }

        // TODO: Build the two-dimensional count and used tables bottom-up.
        // TODO: Trace back one minimum solution using the required tie rule.
        throw new UnsupportedOperationException("TODO: implement minimumCoins");
    }

    /**
     * Selects a subset whose total size is as large as possible without
     * exceeding capacity. Each item may be selected at most once. On a tie,
     * include the current item.
     *
     * @param sizes positive item sizes; array positions are item indices
     * @param capacity nonnegative knapsack capacity
     * @return achieved total, unused capacity, and selected indices in
     *         descending order
     */
    public static KnapsackResult fillKnapsack(int[] sizes, int capacity) {
        validatePositiveArray(sizes, "sizes");
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be nonnegative");
        }

        // TODO: Build the two-dimensional exist and belong tables bottom-up.
        // TODO: Search the final row and trace back one optimal subset.
        throw new UnsupportedOperationException("TODO: implement fillKnapsack");
    }

    private static void validatePositiveArray(int[] values, String name) {
        Objects.requireNonNull(values, name + " must not be null");
        if (values.length == 0) {
            throw new IllegalArgumentException(name + " must not be empty");
        }
        for (int value : values) {
            if (value <= 0) {
                throw new IllegalArgumentException(name + " must contain only positive values");
            }
        }
    }

    public static void main(String[] args) {
        CoinChangeResult coins = minimumCoins(new int[] {6, 4, 1}, 8);
        System.out.println("Coin change: " + coins);

        KnapsackResult knapsack = fillKnapsack(new int[] {2, 4, 5, 7}, 10);
        System.out.println("Knapsack: " + knapsack);
    }
}
