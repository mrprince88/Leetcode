class MedianFinder {
    
    PriorityQueue<Integer> minHeap,maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0 || maxHeap.peek()>num)
            maxHeap.add(num);
        else
            minHeap.add(num);
        
        rebalance();
    }
    
    void rebalance() {
        int n1=minHeap.size(),n2=maxHeap.size();
        if(n1-n2==2) {
            int n=minHeap.remove();
            maxHeap.add(n);
        }
        else if(n2-n1==2) {
            int n=maxHeap.remove();
            minHeap.add(n);
        }
     }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size())
            return (minHeap.peek() + maxHeap.peek())/2.0;
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */