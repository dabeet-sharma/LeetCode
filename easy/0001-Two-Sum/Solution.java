class Solution {
    public int[] twoSum(int[] nums, int target) {

        // i will represent the index of the first number
        int i = 0;

        // j will represent the index of the second number
        int j = 0;

        // This tracks whether we have found a valid pair yet
        boolean found = false;

        // Loop through each element in the array as the first number
        for (i = 0; i < nums.length; i++) 
        {
            // For each i, check the elements after it as the second number
            for (j = i + 1; j < nums.length; j++) 
            {
                // If the sum of nums[i] and nums[j] equals the target,
                // we found the two indices we want
                if (nums[i] + nums[j] == target) 
                {
                    found = true;
                    break; // Exit the inner loop
                }
            }

            // If a pair was found, stop the outer loop too
            if (found) 
            {
                break;
            }
        }

        // Create the result array to store the two indices
        int[] ans = new int[2];

        // Store the indices of the two numbers that add up to target
        ans[0] = i;
        ans[1] = j;

        // Return the answer
        return ans;
    }
}