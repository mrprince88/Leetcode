class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][]dp=new int[triangle.size()][triangle.size()];
        
        return solve(triangle,dp,0,0);
    }
    
    int solve(List<List<Integer>> triangle,int [][]dp,int i,int j) {
        if(i==triangle.size()) 
            return 0;
        
        if(dp[i][j]!=0)
            return dp[i][j];
        
        dp[i][j]=Math.min(triangle.get(i).get(j)+solve(triangle,dp,i+1,j),triangle.get(i).get(j)+solve(triangle,dp,i+1,j+1));
        
        return dp[i][j];
    }
}