package best_time_to_buy_and_sell_stock_ii;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i=0; i<prices.length - 1; i++) {
            if (prices[i + 1] < prices[i]) continue;
            int bestSell = i;
            for (int j=i + 1; j<prices.length; j++) {
                if (j < prices.length - 1 && prices[j + 1] > prices[j]) continue;
                bestSell = j;
                break;
            }
            if (bestSell != i) {
                profit += prices[bestSell] - prices[i];
                i = bestSell;
            } else {
                break;
            }
        }

        return profit;
    }
}
