class Solution {
    public int maxSubArray(int[] nums) {
        int currMax=nums[0],currMin=nums[0],max=nums[0];
        
        for(int i=1;i<nums.length;i++) {
            int temp=currMax;
            currMax=Math.max(currMax+nums[i],Math.max(currMin+nums[i],nums[i]));
            currMin=Math.min(currMin+nums[i],Math.min(nums[i],temp+nums[i]));
            max=Math.max(currMax,max);
        }
        return max;
    }
}