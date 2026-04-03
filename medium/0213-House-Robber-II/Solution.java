class Solution 
{
    public int rob(int[] nums) {

        if(nums.length<=1){return nums[0];}
    
        // Solution is house robber 1 divided into two parts
        // Max from all houses - last house. 
        int n1=0;  
        int n2=0;
        for(int i = 0; i<nums.length-1; i++){

            int current1 = Math.max(nums[i] + n2, n1); 
            n2=n1; 
            n1=current1; 

        }
        // or max from all houses - first house. 
        int m1=0; 
        int m2=0; 
        for(int i = 1; i<nums.length; i++){

            int current2 = Math.max(nums[i] + m2, m1); 
            m2=m1; 
            m1=current2; 
        }

        // return the max from the two
        return Math.max(n1,m1);

    }
}

