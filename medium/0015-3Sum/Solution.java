import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {   
        // Sort the array so we can use the two-pointer technique
        Arrays.sort(nums); 

        // This will store all unique triplets that sum to 0
        List<List<Integer>> answer = new ArrayList<List<Integer>>(); 

        // Try each number as the first number in the triplet
        for (int i = 0; i < nums.length; i++)
        {
            // Skip duplicate values for the first number
            // This prevents duplicate triplets in the answer
            if (i != 0 && nums[i] == nums[i - 1])
            {
                continue;  
            }

            // left and right pointers search for two numbers
            // that add up to -nums[i]
            int left = i + 1;
            int right = nums.length - 1;  
            int target = -nums[i]; 
            
            // Use two pointers to find pairs that sum to target
            while (left < right)
            {
                int sum = nums[left] + nums[right]; 

                // If we found a valid triplet
                if (sum == target)
                {
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                
                    // Skip duplicate values on the left side
                    while (left < right && nums[left] == nums[left + 1])
                    {
                        left++; 
                    }

                    // Skip duplicate values on the right side
                    while (left < right && nums[right] == nums[right - 1])
                    {
                        right--; 
                    }

                    // Move both pointers inward to continue searching
                    left++; 
                    right--; 
                }
                // If the sum is too large, move right inward to reduce it
                else if (sum > target)
                {
                    right--; 
                }
                // If the sum is too small, move left inward to increase it
                else
                {
                   left++; 
                }
            } 
        }

        // Return all unique triplets that sum to 0
        return answer;
    }
}