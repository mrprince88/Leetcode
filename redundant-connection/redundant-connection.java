class Solution {
    
    Set<Integer> visited;
    
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        int n=edges.length;
        
        for(int i=1;i<=n;i++)
            graph.put(i,new ArrayList<>());
        
        for(int []i: edges) {
            visited=new HashSet<>();
            
            if(!graph.get(i[0]).isEmpty() && !graph.get(i[1]).isEmpty() && dfs(graph,i[0],i[1]))
                return i;
            
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        
        return new int[2];
    }
    
    boolean dfs(Map<Integer, List<Integer>> graph,int source,int target) {
        if(!visited.contains(source)) {
            visited.add(source);
            if(source==target) return true;
            for(int i:graph.get(source))
                if(dfs(graph,i,target))
                    return true;
        }
        return false;
    }
}