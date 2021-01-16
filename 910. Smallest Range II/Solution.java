class Solution {
    public int smallestRangeII(int[] A, int K) {
        
        Arrays.sort(A);
        
        int n = A.length, max = A[n - 1], min = A[0], res = max - min;
        
        for (int i = 0; i < n - 1; i++) {
            
            max = Math.max(max, A[i]+2*K);
            min = Math.min(A[i + 1], A[0]+2*K);
            
            res = Math.min(res, max - min);
        }
        return res;
    }
}
