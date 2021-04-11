class Solution {
    
    int [][]dp;
    
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix==null || matrix.length==0)
            return 0;
        
        int n=matrix.length,m=matrix[0].length;
        dp=new int[n][m];
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                max = Math.max (max, DFS (matrix, i, j));
        }
        return max;
    }
    
    int DFS (int matrix [][], int i, int j) {
        if (dp [i][j] > 0)
            return dp [i][j];
        int max = 1;
        
        if (i+1 < matrix.length && matrix [i+1][j] > matrix [i][j])
            max = Math.max (max, 1 + DFS (matrix, i+1, j));
        
        if (i-1 >= 0 && matrix [i-1][j] > matrix [i][j])
            max = Math.max (max, 1 + DFS (matrix, i-1, j));
        
        if (j+1 < matrix[0].length && matrix [i][j+1] > matrix [i][j])
            max = Math.max (max, 1 + DFS (matrix, i, j+1));
        
        if (j-1 >= 0 && matrix [i][j-1] > matrix [i][j])
            max = Math.max (max, 1 + DFS (matrix, i, j-1));
        return dp [i][j] = max;
    }

}