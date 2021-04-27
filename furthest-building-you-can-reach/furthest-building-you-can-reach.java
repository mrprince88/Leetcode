class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int n=heights.length;
        
        int sum=0,ans=0;
        PriorityQueue<Integer> p=new PriorityQueue<>();
        
        for(int i=1;i<n;i++) {
            if(heights[i-1]<heights[i]) {
            
            int diff=heights[i]-heights[i-1];
            
            if(p.size()<ladders)
                p.add(diff);
            
            else if(!p.isEmpty() && p.peek()<diff) {
                sum+=p.poll();
                p.add(diff);
            }
            
            else
                sum+=diff;
            }
            
            if(sum>bricks)
                break;
            ans=i;
        }
        return ans;
    }
}