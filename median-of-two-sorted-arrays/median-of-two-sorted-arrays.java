class Solution {
    
    PriorityQueue<Integer> highers=new PriorityQueue<>();
    PriorityQueue<Integer> lowers=new PriorityQueue<>((a,b)-> Integer.compare(b,a));
    
    void insert(int num) {
        if(lowers.size()==0 || num<lowers.peek())
            lowers.add(num);
        else
            highers.add(num);
    }
    
    void rebalance() {
        if(lowers.size()-highers.size()==2) {
            int n=lowers.poll();
            highers.add(n);
        }
        else if(highers.size()-lowers.size()==2) {
            int n=highers.poll();
            lowers.add(n);
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        for(int i:nums1) {
            insert(i);
            rebalance();
        }
        
        for(int i:nums2) {
            insert(i);
            rebalance();
        }
        
        System.out.println(highers.peek()+" "+lowers.peek());
        if(highers.size()==lowers.size())
            return (lowers.peek()+highers.peek())/2.0;
        
        else
            return (double)((lowers.size()>highers.size())? lowers.peek():highers.peek());
    }
}