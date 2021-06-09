class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> q=new LinkedList<>();
        q.add(0);
        int n=nums.length;
        for(int i=1;i<n;i++) {
            if(q.getFirst()+k<i)
                q.removeFirst();
            nums[i]+=nums[q.getFirst()];
            while(!q.isEmpty() && nums[q.getLast()]<=nums[i])
                q.removeLast();
            q.add(i);
        }
        return nums[n-1];
    }
}