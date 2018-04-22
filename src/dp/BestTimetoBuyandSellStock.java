package dp;

/**
 * Problem 121
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int minCost = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i ++) {
            int currentCost = prices[i];
            int currentProfit = currentCost - minCost;

            minCost = Math.min(minCost, currentCost);
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}
