class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> q=new LinkedList<>();
        q.add(0);
        int n=nums.length;
        for(int i=1;i<n;i++) {
            if(q.peek()+k<i)
                q.poll();
            nums[i]+=nums[q.peek()];
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i])
                q.pollLast();
            q.add(i);
        }
        return nums[n-1];
    }
}