class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n=A.length;
        
        int []res=new int[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for(int i=0;i<n;i++)
            pq.offer(new int[] {B[i],i});
        
        int left = 0;
        int right = n - 1;
        
        while (!pq.isEmpty()) {
            
            int [] curr = pq.poll();
            
            int value = curr[0];
            int index = curr[1];
            
            if (A[right] > value)
                res[index] = A[right--];
            else
                res[index] = A[left++];
        }
        
        return res;
    }
}