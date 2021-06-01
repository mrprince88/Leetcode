class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) maxArea=Math.max(maxArea,solver(grid,i,j));
            }
        }
        return maxArea;
    }
    
    int solver(int [][]grid,int i,int j) {
        if(i==grid.length || i==-1 ||j==grid[0].length || j==-1 || grid[i][j]==0)
            return 0;
        
        grid[i][j]=0;
        return 1+ solver(grid,i+1,j) + solver(grid,i,j+1) + solver(grid,i-1,j) + solver(grid,i,j-1);
    }
}