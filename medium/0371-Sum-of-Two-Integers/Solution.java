class Solution {
    public int getSum(int a, int b)         
    {
        // xor stores the sum of a and b without carrying
        // It adds each bit position where the bits are different
        int xor = a ^ b;

        // and finds the positions where both bits are 1
        // Those positions create a carry
        int and = a & b;

        // Keep processing until there are no more carry bits left
        while (and != 0) 
        {
            // Shift the carry left by 1 because a carry affects the next bit position
            int carried = and << 1;

            // Find any new carry created when adding xor and carried
            and = xor & carried;

            // Add the current value and the carried bits without carry using XOR
            xor = xor ^ carried;
        }   

        // xor now contains the final sum
        return xor;
    }
}