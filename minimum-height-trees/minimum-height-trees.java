class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n<2) {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(i);
            return list;
        }
        
        List<Set<Integer>> neighbors=new ArrayList<>();
        
        for(int i=0;i<n;i++)
            neighbors.add(new HashSet<>());
        
        for(int []edge: edges) {
            neighbors.get(edge[0]).add(edge[1]); 
            neighbors.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves=new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            if(neighbors.get(i).size()==1)
                leaves.add(i);
        }
        
        int remaining=n;
        
        while(remaining>2) {
            
            remaining-=leaves.size();
            List<Integer> newLeaves=new ArrayList<>();
            
            for(int leaf: leaves) {
                Integer neighbor=neighbors.get(leaf).iterator().next();
                neighbors.get(neighbor).remove(leaf);
                if(neighbors.get(neighbor).size()==1)
                    newLeaves.add(neighbor);
            }
            leaves=newLeaves;
        }
        
        return leaves;
    }
}