class Solution {
    int max;
    public int coinChange(int[] coins, int amt) {
        max=amt+1;
        int res = solver(coins,amt,0,new int[coins.length][amt+1]);
        return res==max ? -1: res;
    }
    
    int solver(int []coins,int amt,int idx,int [][]dp) {
        if(idx==coins.length || amt<0)
            return max;
        
        if(dp[idx][amt]>0)
            return dp[idx][amt];
        
        if(amt==0)
            return 0;
        
        int option1=1+solver(coins,amt-coins[idx],idx,dp);
        int option2=solver(coins,amt,idx+1,dp);
        dp[idx][amt]=Math.min(option1,option2);
        return dp[idx][amt];
    }
}