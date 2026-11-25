class Solution {
    public int maxProfit(int[] prices) {
        int lowestBuy = prices[0];
        int bestProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestBuy) {
                lowestBuy = prices[i];
            }
            if (prices[i] - lowestBuy > bestProfit) {
                bestProfit = prices[i] - lowestBuy;
            }
        }

        return bestProfit;
    }
}
