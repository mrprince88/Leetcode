class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=nums[0],minSum=nums[0];
        int currMin=0,currMax=0,total=0;
        
        for(int i:nums) {
            currMax=Math.max(currMax+i,i);
            currMin=Math.min(currMin+i,i);
            maxSum=Math.max(maxSum,currMax);
            minSum=Math.min(minSum,currMin);
            total+=i;
        }
        
        return minSum==total ? maxSum : Math.max(maxSum,total-minSum);
     }
}