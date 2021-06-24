class Solution {
    public int stoneGameVII(int[] nums) {
        int n=nums.length;
        
        int []sum=new int[n];
        sum[0]=nums[0];
        
        for(int i=1;i<n;i++) sum[i]=sum[i-1]+nums[i];
        
        int []dp=new int[n+1];
        
        for(int i=0;i<n-1;i++)
            dp[i]=Math.max(nums[i],nums[i+1]);
        
        for(int i=2;i<n;i++) {
            
            for(int j=0;j<n-i;j++) {
                dp[j]=Math.max(sum[j+i-1]-(j>0 ? sum[j-1]:0) - dp[j], sum[i+j]-sum[j]-dp[j+1]);
            }
        }
        
        return dp[0];
    }
}