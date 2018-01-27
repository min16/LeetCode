package dp;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Problem 746
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length == 0) return 0;
        if (length == 1) return cost[0];

        int oneStepBeforeCost = cost[1];
        int twoStepBeforeCost = cost[0];
        int minCost = Math.min(oneStepBeforeCost, twoStepBeforeCost);

        for (int i = 2; i < length; i ++) {
            int currentCost = cost[i] + Math.min(oneStepBeforeCost, twoStepBeforeCost);
            twoStepBeforeCost = oneStepBeforeCost;
            oneStepBeforeCost = currentCost;

            minCost = Math.min(oneStepBeforeCost, twoStepBeforeCost);
        }

        return minCost;
    }

    @Test
    public void test() {
        assertEquals(6, minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
