class Solution {
    List<List<String>> list;
    public List<List<String>> solveNQueens(int n) {
        list=new ArrayList<>();
        char [][]a=new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(a[i],'.');
        nQueens(a,n,0);
        return list;
    }
    
    void nQueens(char [][]a,int n,int i) {
        if(i==n) {
            List<String> sol=getString(a,n);
            list.add(sol);
        }
        for(int j=0;j<n;j++) {
            if(isPossible(a,n,i,j)) {
                a[i][j]='Q';
                nQueens(a,n,i+1);
                a[i][j]='.';
            }
        }
    }
    
    List<String> getString(char [][]a,int n) {
        List<String> sol=new ArrayList<>();
        for(int i=0;i<n;i++)
            sol.add(String.valueOf(a[i]));
        return sol;
    }
    
    boolean isPossible(char [][]a,int n,int row,int col) {
        for(int i=row-1;i>=0;i--)
            if(a[i][col]=='Q')
                return false;
        
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
            if(a[i][j]=='Q')
                return false;
        
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
            if(a[i][j]=='Q')
                return false;
        return true;
    }
}