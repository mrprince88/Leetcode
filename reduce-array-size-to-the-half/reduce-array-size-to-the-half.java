class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        
        for (int i=0;i<n;i++)
             map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        
        for(int i: map.keySet())
            pq.add(map.get(i));
        
        int res=0,currSum=0;
        
        while(!pq.isEmpty()) {
            int curr=pq.poll();
            currSum=currSum+curr;
            res++;
            if(currSum>=n/2)
                return res;
        }
        return res;
        
    }
}