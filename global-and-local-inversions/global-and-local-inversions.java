class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n=A.length;
        int c=0,d=0;
        
        for(int i=0;i<n;i++) {
            if(Math.abs(A[i]-i)>1)
                return false; 
        }
        return true;
    }
}