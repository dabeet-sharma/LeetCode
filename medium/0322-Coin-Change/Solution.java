import java.util.Arrays;
class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        // dp[i] will store the minimum number of coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Fill the array with a value larger than any possible valid answer
        // This acts like "infinity" to show that the amount has not been reached yet
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0;

        // Build the solution for every amount from 1 up to the target amount
        for (int i = 1; i <= amount; i++)
        {
            // Try every coin for the current amount i
            for (int c : coins)
            {
                // Only use the coin if it does not make the remaining amount negative
                if (i - c >= 0)
                {
                    // Either keep the current best answer for dp[i],
                    // or use coin c and add 1 to the solution for dp[i - c]
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        // If dp[amount] is still larger than amount,
        // then no valid combination of coins could make the target
        if (dp[amount] > amount) return -1;

        // Otherwise return the minimum number of coins needed
        return dp[amount];
    }
}