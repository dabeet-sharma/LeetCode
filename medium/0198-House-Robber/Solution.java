class Solution 
{
    public int rob(int[] nums) {
    
        // Start from the right

        int n1=0; // adjacent 
        int n2=0;// i-2


        for(int num :nums){

            int current = Math.max(num + n2, n1); 
            // Carry forward 
            n2=n1; 
            n1=current; 

        }
        return Math.max(n1,n2);

    }
}