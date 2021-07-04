class Solution {
    public int countVowelPermutation(int n) {
        long [][]dp=new long[n+1][5];
        Arrays.fill(dp[1],1);
        int mod=(int)(1e9+7);
        
        for(int i=2;i<=n;i++) {
            dp[i][0]=(dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%mod;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
            dp[i][2]=(dp[i-1][1]+dp[i-1][3])%mod;
            dp[i][3]=dp[i-1][2];
            dp[i][4]=(dp[i-1][3]+dp[i-1][2])%mod;
        }
        
        long ans=0;
        
        for(long i: dp[n])
            ans=(ans+i)%mod;
        
        return (int)ans;
    }
}