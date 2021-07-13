class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []colors=new int[n];
        
        for(int i=0;i<n;i++) {
            if(colors[i]==0 && !check(i,graph,colors,1))
                return false;
        }
        return true;
    }
    
    boolean check(int curr,int [][]graph,int []colors,int color) {
        colors[curr]=color;
        
        for(int i=0;i<graph[curr].length;i++) {
            int neighbor=graph[curr][i];
            if(colors[neighbor]==-color) continue;
            
            if(colors[neighbor]==color || !check(neighbor,graph,colors,-color))
                return false;
        }
        return true;
    }
}