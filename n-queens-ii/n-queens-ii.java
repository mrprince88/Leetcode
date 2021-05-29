class Solution {

    public int totalNQueens(int n) {
        int [][]a=new int[n][n];
        return nQueens(n,a,0);
    }
    
    int nQueens(int n,int [][]a,int idx) {
        if(idx==n) {
            return 1;
        }
        int count=0;
        for(int i=0;i<n;i++) {
            if(isValid(a,n,idx,i)) {
                a[idx][i]=1;
                count+=nQueens(n,a,idx+1);
                a[idx][i]=0;
            }
        }
        return count;
    }
    
    boolean isValid(int [][]a,int n,int r,int c) {
        for(int i=r-1;i>=0;i--)
            if(a[i][c]==1)
                return false;
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
            if(a[i][j]==1)
                return false;
        for(int i=r-1,j=c+1;i>=0 && j<n;i--,j++)
            if(a[i][j]==1)
                return false;
        return true;
    }
}