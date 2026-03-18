import java.util.Stack;

class Solution {
    
    public boolean isValid(String s) {
        
        // Create a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Traverse through each character in the string
        for (int i = 0; i < s.length(); i++) {

            // If the current character is an opening bracket, push it onto the stack
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                char a = s.charAt(i);
                stack.push(a);  
            }
            else {
                // If we find a closing bracket but the stack is empty,
                // there is no matching opening bracket
                if (stack.isEmpty()) { 
                    return false;
                }

                // Pop the most recent opening bracket from the stack
                char a = stack.pop();

                // Current character is the closing bracket
                char b = s.charAt(i);

                // Check if the opening and closing brackets match
                // Example: '(' matches ')', '{' matches '}', '[' matches ']'
                if (!isMatch(a, b)) { 
                    return false;
                } 
            }
        }

        // At the end, the stack should be empty if all brackets matched properly
        return stack.isEmpty();
    }

    private boolean isMatch(char a, char b) {
        // Returns true only if a and b are a matching pair of brackets
        return (a == '(' && b == ')') || 
               (a == '{' && b == '}') || 
               (a == '[' && b == ']');  
    }
}