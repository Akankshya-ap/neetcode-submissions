class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2) return 0;

        int min = prices[0];
        int max = 0;
        int profit = 0;

        for(int i = 0;i<n; i++){
            if(prices[i]<min){
                profit = Math.max(profit, max-min);
                max = 0;
                min = prices[i];
            }
            max = Math.max(prices[i], max);
            // if(prices[i]>max){
            //     profit = Math.max(profit, max-min);
            //     max=prices[i];
            // }
        }
        profit = Math.max(profit, max-min);
        return profit;
    }
}
