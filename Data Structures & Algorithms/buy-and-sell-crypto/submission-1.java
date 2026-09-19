class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2) return 0;

        int min = prices[0];
        int profit = 0;

        for(int i = 0;i<n; i++){
            profit = Math.max(profit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
