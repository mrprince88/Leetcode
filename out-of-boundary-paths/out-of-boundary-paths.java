class Solution {
    int mod=1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int [][][]dp=new int[m+1][n+1][maxMove+1];
        for(int[][]i: dp) for(int []j: i) Arrays.fill(j,-1);
        
        return solver(m,n,maxMove,startRow,startColumn,dp);
    }
    
    int solver(int m,int n,int moves,int i,int j,int [][][]dp) {
        if(i==m || j==n || i==-1 || j==-1)
            return 1;
        
        if(moves==0)
            return 0;
        
        if(dp[i][j][moves] >= 0)
          return dp[i][j][moves];  
        
        dp[i][j][moves]= ((solver(m,n,moves-1,i+1,j,dp) + solver(m,n,moves-1,i,j+1,dp))%mod +
            (solver(m,n,moves-1,i-1,j,dp) + solver(m,n,moves-1,i,j-1,dp))%mod)%mod;
        
        return dp[i][j][moves];
    }
}