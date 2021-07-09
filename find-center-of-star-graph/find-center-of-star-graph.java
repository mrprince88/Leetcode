class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> set=new HashSet<>();
        
        for(int []edge: edges) {
            if(set.contains(edge[0])) return edge[0];
            if(set.contains(edge[1])) return edge[1];
            set.add(edge[0]); set.add(edge[1]);
        }
        
        return -1;
    }
}