class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int el: nums){
            pq.offer(el);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
