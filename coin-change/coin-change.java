class Solution {
    int max;
    public int coinChange(int[] coins, int amt) {
        max=amt+1;
        
        int []dp=new int[amt+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        
        for(int i=0;i<coins.length;i++) {
            for(int j=0;j<=amt;j++) {
                if(j>=coins[i])
                    dp[j]=Math.min(dp[j],1+dp[j-coins[i]]);
            }
        }
        return dp[amt]==max ?-1: dp[amt];
    }
}