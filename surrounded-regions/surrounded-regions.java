class Solution {
    public void solve(char[][] board) {
        int m=board.length,n=board[0].length;
        
        for(int i=0;i<n;i++) {
            if(board[0][i]=='O')
                dfs(board,0,i);
            if(board[m-1][i]=='O')
                dfs(board,m-1,i);
        }
        
        for(int i=0;i<m;i++) {
            if(board[i][0]=='O')
                dfs(board,i,0);
            if(board[i][n-1]=='O')
                dfs(board,i,n-1);
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='*')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    
    int [][]dirs={{1,0},{0,1},{-1,0},{0,-1}};
    
    void dfs(char [][]grid,int i,int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='O')
            return;
        grid[i][j]='*';
        
        for(int []dir: dirs)
            dfs(grid,dir[0]+i,dir[1]+j);
    }
}