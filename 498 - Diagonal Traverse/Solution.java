class Solution {
    
    static boolean OutOfBound(int row,int col,int n,int m) {
        return row<0 || row>n-1 || col<0 || col>m-1;
     }
     
    public int[] findDiagonalOrder(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        
        int row=0,col=0,i=0,n=matrix.length, m=matrix[0].length;
        
        int []res=new int[n*m];
        
        boolean goingDown=false;
        
        while(!OutOfBound(row,col,n,m)) {
            
            res[i++]=matrix[row][col];
            if(goingDown) {
                if(col==0 || row==n-1) {
                    goingDown=false;
                    if(row==n-1)
                        col++;
                    else
                        row++;
                }
                else {
                    row++;
                    col--;
                }
            }
            else {
                if(row==0 ||col==m-1) {
                    goingDown=true;
                    if(col==m-1)
                        row++;
                    else
                        col++;
                }
                else {
                    row--;
                    col++;
                    
                }
            }
        }
        return res;
    }
}
