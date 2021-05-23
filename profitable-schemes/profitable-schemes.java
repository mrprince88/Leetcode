class Solution {
    public int profitableSchemes(int N, int P, int[] group, int[] profit) {
        int [][]dp=new int[P+1][N+1];
        
        dp[0][0]=1;
        
        int res=0, mod=(int)(1e9+7);
        
        for(int k=0;k<group.length;k++) {
            int p=profit[k],g=group[k];
            
            for(int i=P;i>=0;i--)
                for(int j=N-g;j>=0;j--)
                    dp[Math.min(i+p,P)][j+g]=(dp[Math.min(i+p,P)][j+g]+dp[i][j])%mod;
        }
        
        for(int i: dp[P])
            res=(res+i)%mod;
        
        return res;
    }
}