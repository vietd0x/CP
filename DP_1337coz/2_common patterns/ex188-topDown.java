class Solution {
    private int[] prices;
    private int[][][] memo;
    
    private int dp(int i, int transactionsRemaining, int holding) {
        // Base cases
        if (transactionsRemaining == 0 || i == prices.length) {
            return 0;
        }
        
        if (memo[i][transactionsRemaining][holding] == 0) {
            int doNothing = dp(i + 1, transactionsRemaining, holding);
            int doSomething;

            if (holding == 1) {
                // Sell Stock
                doSomething = prices[i] + dp(i + 1, transactionsRemaining - 1, 0);
            } else {
                // Buy Stock
                doSomething = -prices[i] + dp(i + 1, transactionsRemaining, 1);
            }
            
            // Recurrence relation. Choose the most profitable option.
            memo[i][transactionsRemaining][holding] = Math.max(doNothing, doSomething);
        }
        
        return memo[i][transactionsRemaining][holding];
    }
    
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length][k + 1][2];
        return dp(0, k, 0);
    }
}
