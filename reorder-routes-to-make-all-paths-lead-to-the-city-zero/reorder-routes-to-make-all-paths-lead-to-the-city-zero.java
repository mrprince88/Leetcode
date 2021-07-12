class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adjList=new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        for(int []cnt: connections) {
            adjList.get(cnt[0]).add(cnt[1]);
            adjList.get(cnt[1]).add(-cnt[0]);
        }
        return dfs(adjList,new boolean[n],0);
    }
    
    int dfs(List<List<Integer>> graph,boolean []visited,int from) {
        visited[from]=true;
        int change=0;
        
        for(int i: graph.get(from)) {
            if(!visited[Math.abs(i)])
                change+=dfs(graph,visited,Math.abs(i)) + (i>0 ? 1:0);
        }
        
        return change;
        
    }
}