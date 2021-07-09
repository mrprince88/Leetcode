class Solution {
    List<List<Integer>> res; int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n=graph.length;
        res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(graph,0,path);
        return res;
    }
    
    void dfs(int [][]graph,int node,List<Integer> path) {
        if(node==n-1) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i:graph[node]) {
            path.add(i);
            dfs(graph,i,path);
            path.remove(path.size()-1);
        }
    }
}