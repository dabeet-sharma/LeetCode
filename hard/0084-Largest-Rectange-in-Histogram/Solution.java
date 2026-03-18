import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        // Number of bars in the histogram
        int n = heights.length; 

        // Store the maximum rectangle area found so far
        int maxArea = 0;

        // leftSmall[i] = index of the first smaller bar to the left of i
        int[] leftSmall = new int[n];

        // rightSmall[i] = index of the first smaller bar to the right of i
        int[] rightSmall = new int[n];

        // Monotonic increasing stack storing indices
        Stack<Integer> stack = new Stack<>(); 
 
        // Find the nearest smaller element on the left for each bar
        for (int i = 0; i < n; i++)
        {
            // Pop until the top of the stack is strictly smaller than heights[i]
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
            {
                stack.pop();               
            }

            // If stack is empty, there is no smaller bar on the left
            if (stack.isEmpty())
            {
                leftSmall[i] = -1; 
            }
            else
            {
                // Top of stack is the nearest smaller bar to the left
                leftSmall[i] = stack.peek(); 
            } 

            // Push current index onto the stack
            stack.push(i); 
        }

        // Clear stack so we can reuse it for the right side
        stack.clear();

        // Find the nearest smaller element on the right for each bar
        for (int i = n - 1; i >= 0; i--)
        {
            // Pop until the top of the stack is strictly smaller than heights[i]
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
            {
                stack.pop();               
            }

            // If stack is empty, there is no smaller bar on the right
            if (stack.isEmpty())
            {
                rightSmall[i] = n; 
            }
            else
            {
                // Top of stack is the nearest smaller bar to the right
                rightSmall[i] = stack.peek(); 
            } 

            // Push current index onto the stack
            stack.push(i); 
        }

        // Compute the maximum rectangle using each bar as the limiting height
        for (int i = 0; i < n; i++) 
        {
            // Width is between the first smaller bar on the left
            // and the first smaller bar on the right
            int width = rightSmall[i] - leftSmall[i] - 1; 

            // Area using heights[i] as the rectangle height
            int area = heights[i] * width;

            // Update maximum area if this rectangle is larger
            if (area > maxArea) 
            {
                maxArea = area;
            }
        }

        // Return the largest rectangle found
        return maxArea; 
    }
}