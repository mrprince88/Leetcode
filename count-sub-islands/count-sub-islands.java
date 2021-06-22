class Solution {
    public int countSubIslands(int[][] B, int[][] A) {
        int m = A.length, n = A[0].length, res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (A[i][j] == 1 && dfs(B, A, i, j))
                    res++;
        return res;
    }


     boolean dfs(int[][] B, int[][] A, int i, int j) {
        int m = A.length, n = A[0].length; boolean res = true;
        if (i < 0 || i == m || j < 0 || j == n || A[i][j] == 0) return true;
        A[i][j] = 0;
        res &= dfs(B, A, i - 1, j);
        res &= dfs(B, A, i + 1, j);
        res &= dfs(B, A, i, j - 1);
        res &= dfs(B, A, i, j + 1);
        return res & B[i][j] ==1;
    }
}