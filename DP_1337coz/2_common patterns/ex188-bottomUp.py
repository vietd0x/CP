class Solution:        
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        dp = [[[0] * 2 for _ in range(k + 1)] for __ in range(n + 1)]
        
        for i in range(n - 1, -1, -1):
            for transactions_remaining in range(1, k + 1):
                for holding in range(2):
                    do_nothing = dp[i + 1][transactions_remaining][holding]
                    if holding:
                        # Sell stock
                        do_something = prices[i] + dp[i + 1][transactions_remaining - 1][0]
                    else:
                        # Buy stock
                        do_something = -prices[i] + dp[i + 1][transactions_remaining][1]
                    
                    # Recurrence relation
                    dp[i][transactions_remaining][holding] = max(do_nothing, do_something)

        return dp[0][k][0]
