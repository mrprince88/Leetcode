class Solution {
    public int[] avoidFlood(int[] rains) {
        int []ans=new int[rains.length];
        Map<Integer,Integer> visited=new HashMap<>();
        TreeSet<Integer> empty=new TreeSet<>();
        Arrays.fill(ans,1);
        for(int i=0;i<rains.length;i++) {
            int lake=rains[i];
            
            if(lake>0) {
                ans[i]=-1;
                if(visited.containsKey(lake)) {
                    Integer emptyDay=empty.higher(visited.get(lake));
                    if(emptyDay==null) return new int[0];
                    
                    ans[emptyDay]=lake;
                    empty.remove(emptyDay);
                }
                visited.put(lake,i);
            }
            else
                empty.add(i);
        }
        return ans;
    }
}