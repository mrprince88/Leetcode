class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int [][]arr=new int[n][2];
        
        for(int i=0;i<n;i++)
            arr[i]=new int[]{speed[i],efficiency[i]};
        
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>(k,(a,b)->a-b);
        long res=0,sum=0,mod=(long)(1e9+7);
        
        for(int[] i:arr) {
            pq.add(i[0]);
            sum+=i[0];
            if(pq.size()>k) sum-=pq.poll();
            res=Math.max(res,sum*i[1]);
        }
        
        return (int)(res%mod);
        
    }
}