package edu.wne.cs366;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DynamicProgrammingTest {

    @Test
    @DisplayName("Coin change finds the non-greedy optimum from Homework 06")
    void coinChangeFindsNonGreedyOptimum() {
        DynamicProgramming.CoinChangeResult result =
                DynamicProgramming.minimumCoins(new int[] {6, 4, 1}, 8);

        assertEquals(2, result.minimumCount());
        assertEquals(List.of(4, 4), result.coins());
    }

    @Test
    @DisplayName("Coin change reports an impossible amount")
    void coinChangeReportsImpossibleAmount() {
        DynamicProgramming.CoinChangeResult result =
                DynamicProgramming.minimumCoins(new int[] {6, 4}, 5);

        assertEquals(-1, result.minimumCount());
        assertEquals(List.of(), result.coins());
    }

    @Test
    @DisplayName("Coin change handles amount zero")
    void coinChangeHandlesZero() {
        DynamicProgramming.CoinChangeResult result =
                DynamicProgramming.minimumCoins(new int[] {5, 2}, 0);

        assertEquals(0, result.minimumCount());
        assertEquals(List.of(), result.coins());
    }

    @Test
    @DisplayName("Coin change prefers an earlier denomination on a tie")
    void coinChangeUsesRequiredTieRule() {
        DynamicProgramming.CoinChangeResult result =
                DynamicProgramming.minimumCoins(new int[] {3, 2, 1}, 4);

        assertEquals(2, result.minimumCount());
        assertEquals(List.of(3, 1), result.coins());
    }

    @Test
    @DisplayName("Knapsack reconstructs the Homework 06 subset")
    void knapsackReconstructsHomeworkSubset() {
        DynamicProgramming.KnapsackResult result =
                DynamicProgramming.fillKnapsack(new int[] {2, 4, 5, 7}, 10);

        assertEquals(9, result.totalSize());
        assertEquals(1, result.unusedCapacity());
        assertEquals(List.of(3, 0), result.selectedIndices());
    }

    @Test
    @DisplayName("Knapsack finds an exact fill")
    void knapsackFindsExactFill() {
        DynamicProgramming.KnapsackResult result =
                DynamicProgramming.fillKnapsack(new int[] {2, 3, 7, 5, 6}, 16);

        assertEquals(16, result.totalSize());
        assertEquals(0, result.unusedCapacity());
        assertEquals(List.of(4, 3, 1, 0), result.selectedIndices());
    }

    @Test
    @DisplayName("Knapsack includes the current item on a tie")
    void knapsackUsesRequiredTieRule() {
        DynamicProgramming.KnapsackResult result =
                DynamicProgramming.fillKnapsack(new int[] {4, 4}, 4);

        assertEquals(4, result.totalSize());
        assertEquals(0, result.unusedCapacity());
        assertEquals(List.of(1), result.selectedIndices());
    }

    @Test
    @DisplayName("Methods reject invalid inputs")
    void methodsRejectInvalidInputs() {
        assertThrows(NullPointerException.class,
                () -> DynamicProgramming.minimumCoins(null, 4));
        assertThrows(IllegalArgumentException.class,
                () -> DynamicProgramming.minimumCoins(new int[] {}, 4));
        assertThrows(IllegalArgumentException.class,
                () -> DynamicProgramming.minimumCoins(new int[] {1, 0}, 4));
        assertThrows(IllegalArgumentException.class,
                () -> DynamicProgramming.minimumCoins(new int[] {1}, -1));

        assertThrows(NullPointerException.class,
                () -> DynamicProgramming.fillKnapsack(null, 4));
        assertThrows(IllegalArgumentException.class,
                () -> DynamicProgramming.fillKnapsack(new int[] {}, 4));
        assertThrows(IllegalArgumentException.class,
                () -> DynamicProgramming.fillKnapsack(new int[] {2, -1}, 4));
        assertThrows(IllegalArgumentException.class,
                () -> DynamicProgramming.fillKnapsack(new int[] {2}, -1));
    }
}
