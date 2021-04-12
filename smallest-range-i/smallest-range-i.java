class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max=A[0],min=A[0];
        
        for(int i:A) {
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        
        return Math.max(0,max-min-2*K);
    }
}