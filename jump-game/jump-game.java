class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        
        int res=0;
        
        for(int i=0;i<nums.length;i++) {
            if(res < i) return false;
            
            res=Math.max(res,i+nums[i]);
        }
        return true;
    }
}