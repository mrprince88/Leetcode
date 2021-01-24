class Solution {
    int[][] mat;
    int n, m;
    public void sortDiagonal(int i, int j) {
        Queue<Integer> diagonal = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (i < n && j < m) {
            diagonal.add(mat[i][j]);
            ++i;
            ++j;    
        }
​
        while (i > 0 && j > 0) {
            --i;
            --j;
            mat[i][j] = diagonal.remove();    
        }
    }
    
    public int[][] diagonalSort(int[][] mat) {
        this.mat = mat;
        n = mat.length;
        m = mat[0].length;
​
        for (int i = 0; i < n; ++i) {
            sortDiagonal(i, 0);       
        } 
        for (int j = 0; j < m; ++j) {
            sortDiagonal(0, j);  
        } 
        return mat;
    }
}
