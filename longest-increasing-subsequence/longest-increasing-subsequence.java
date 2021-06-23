class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int []dp=new int[nums.length];
        int best=0;
        for(int i=0;i<n;i++) {
            dp[i]=1;
            
            for(int j=i-1;j>=0;j--) {
                if(nums[j]>=nums[i])
                    continue;
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            best=Math.max(dp[i],best);
        }
        return best;
    }
}