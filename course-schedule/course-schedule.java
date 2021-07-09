class Solution {
    
    List<List<Integer>> adjList;
    
    void buildGraph(int num,int [][]prereqs) {
        adjList=new ArrayList<>();
        
        for(int i=0;i<num;i++)
            adjList.add(new ArrayList<>());
        
        for(int []i: prereqs) {
            adjList.get(i[0]).add(i[1]);
        }   
    }
    
    boolean checkCycle(int num) {
        int []visited=new int[num];
        
        for(int i=0;i<num;i++) {
            if(dfs(visited,i)) return true;
        }
        
        return false;
    }
    
    boolean dfs(int[] visited,int v) {
        if(visited[v]==2) return false;
        if(visited[v]==1) return true;
        
        visited[v]=1;
        
        for(int i:adjList.get(v)) {
            if(dfs(visited,i)) return true;
        }
        
        visited[v]=2;
        return false;
    }
    
    public boolean canFinish(int num, int[][] prereqs) {
        buildGraph(num,prereqs);
        return !checkCycle(num);
    }
}