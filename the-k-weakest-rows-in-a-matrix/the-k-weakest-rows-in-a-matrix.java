class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(k,(a,b)->a[0]!=b[0] ? a[0]-b[0]: a[1]-b[1]);
        
        for(int i=0;i<mat.length;i++) {
            int curr=0;
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==1)
                    curr++;
            }
            pq.add(new int[]{curr,i});
        }
        int []ans=new int[k];
        int c=0;
        
        while(c!=k)
            ans[c++]=pq.poll()[1];
        
        return ans;
    }
}