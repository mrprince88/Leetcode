class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n=nums.length,prev=-1,dp=0,res=0;
        
        for(int i=0;i<n;i++) {
            if(nums[i]<left)
                res+=dp;
            else if(nums[i]>right) {
                dp=0;
                prev=i;
            }
            else if(nums[i]>=left && nums[i]<=right) {
                dp=i-prev;
                res+=dp;
            }
        }
        
        return res;
    }
}