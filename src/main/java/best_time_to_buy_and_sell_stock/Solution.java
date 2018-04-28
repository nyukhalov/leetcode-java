package best_time_to_buy_and_sell_stock;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int mp = 0;
        int buyAt = 0;
        for (int i=0; i<prices.length; i++) {
            int p = prices[i];
            if (p < prices[buyAt]) {
                buyAt = i;
            } else if (p - prices[buyAt] > mp) {
                mp = p - prices[buyAt];
            }
        }
        return mp;
    }
}
