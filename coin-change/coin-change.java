class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length,m=amount;
        int [][]dp=new int[n][m+1];
        
        for(int i=0;i<n;i++)
            for(int j=1;j<=m;j++)
                dp[i][j]=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<=m;j++) {
                if(i>0)
                dp[i][j]=dp[i-1][j];
                
                if(coins[i]<=j && dp[i][j-coins[i]]!=Integer.MAX_VALUE)
                    dp[i][j]=Math.min(dp[i][j],1+dp[i][j-coins[i]]);
            }
        }
        
        return dp[n-1][m]!=Integer.MAX_VALUE ? dp[n-1][m]:-1;
    }
}