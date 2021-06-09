class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(solve(nums,0,nums.length-2),solve(nums,1,nums.length-1));
    }
    
    int solve(int []nums,int low,int high) {
        int in=0,ex=0;
        for(int i=low;i<=high;i++) {
            int ic=in,e=ex;
            in=ex+nums[i];
            ex=Math.max(e,ic);
        }
        return Math.max(in,ex);
    }
}