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
    
    int[] topologicalSort(int num) {
        int []visited=new int[num];
        int []res=new int[num];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<num;i++)
            if(checkCycle(i,visited,list)) return new int[0];
        
        int c=0;
        for(int i: list)
            res[c++]=i;
        return res;
    }
    
    boolean checkCycle(int v,int []visited,List<Integer> list) {
        if(visited[v]==2) return false;
        if(visited[v]==1) return true;
        
        visited[v]=1;
        
        for(int i: adjList.get(v))
            if(checkCycle(i,visited,list)) return true;
        
        visited[v]=2;
        list.add(v);
        return false;
    }
    
    public int[] findOrder(int num, int[][] prereqs) {
        buildGraph(num, prereqs);
        return topologicalSort(num);
    }
}