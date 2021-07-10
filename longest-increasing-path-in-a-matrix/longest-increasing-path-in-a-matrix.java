class Solution {
    int [][]dp;
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int ans=0;
        dp=new int[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                ans=Math.max(ans,dfs(matrix,i,j,-1));
            }
        }
        return ans;
    }
    
    int dfs(int [][]matrix,int i,int j,int prev) {
        if(i==-1 || j==-1 || i==matrix.length || j==matrix[0].length || matrix[i][j]<=prev) 
            return 0;

        if(dp[i][j]>0)
            return dp[i][j];

        int ans=0;
        ans=Math.max(ans,dfs(matrix,i+1,j,matrix[i][j]));
        
        ans=Math.max(ans,dfs(matrix,i,j+1,matrix[i][j]));
        
        ans=Math.max(ans,dfs(matrix,i,j-1,matrix[i][j]));
        
        ans=Math.max(ans,dfs(matrix,i-1,j,matrix[i][j]));
            
        dp[i][j]=ans+1;
            
        return dp[i][j];
    }
}