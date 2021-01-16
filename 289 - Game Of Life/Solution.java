class Solution {
    public void gameOfLife(int[][] board) {

        int[] neighbors = { 0, 1, -1 };
        int row = board.length, col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int k = r + neighbors[i];
                            int l = c + neighbors[j];

                            if ((l < col && l >= 0) && (k < row && k >= 0) && Math.abs(board[k][l]) == 1)
                                liveNeighbors++;
                        }
                    }
                }
                if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3))
                    board[r][c] = -1;
                else if (board[r][c] == 0 && liveNeighbors == 3)
                    board[r][c] = 2;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1)
                    board[i][j] = 0;
                else if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }

}