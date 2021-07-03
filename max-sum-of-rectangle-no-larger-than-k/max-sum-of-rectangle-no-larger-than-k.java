class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return 0;
    int rows = matrix.length, cols = matrix[0].length;
    int[][] areas = new int[rows+1][cols+1];
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            areas[r+1][c+1]=areas[r+1][c]+areas[r][c+1]+matrix[r][c]-areas[r][c];
        }
    }
    int max = Integer.MIN_VALUE;
    for (int r1 = 1; r1 <= rows; r1++) {
        for (int c1 = 1; c1 <= cols; c1++) {
            for (int r2 = r1; r2 <= rows; r2++) {
                for (int c2 = c1; c2 <= cols; c2++) {
                    int area = areas[r2][c2]-areas[r1-1][c2]-areas[r2][c1-1]+areas[r1-1][c1-1];
                    if (area <= k)
                        max = Math.max(max, area);
                }
            }
        }
    }
    return max;
}
}