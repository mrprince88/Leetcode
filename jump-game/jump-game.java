class Solution {
    public boolean canJump(int[] nums) {
        
        int n=nums.length;
        
        int last=n-1;
        
        for(int i=n-2;i>=0;i--)
            if(i+nums[i]>=last) last=i;
        
        return last<=0;
    }
}