class Solution 
{
    public int maxProfit(int[] prices) 
    {
        // left keeps track of the index of the lowest price seen so far
        // This represents the best day to buy up to the current point
        int left = 0;  

        // maxP stores the maximum profit found so far
        int maxP = 0; 

        // Start from day 1 since day 0 is our initial buying day
        for (int i = 1; i < prices.length; i++)
        {
            // If we find a lower price than our current buy price,
            // move left to this new index because it is a better day to buy
            if (prices[left] > prices[i])
            {
                left = i;   
            }

            // This check is unnecessary because i is already guaranteed
            // to be less than prices.length by the for-loop condition,
            // but it does not hurt anything
            if (i < prices.length)
            {
                // Calculate the profit if we sell on day i
                // and compare it with the maximum profit seen so far
                if (maxP < (prices[i] - prices[left]))
                {
                    maxP = prices[i] - prices[left]; 
                }
            }
        }

        // Return the best profit found
        // If no profit is possible, this returns 0
        return maxP; 
    }
}