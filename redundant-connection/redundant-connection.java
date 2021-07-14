class Solution {
    
    class Node {
        int parent,rank;
        Node(int p,int r) {
            parent=p; rank=r;
        }
    }
    
    List<Node> dsuf;
    public int[] findRedundantConnection(int[][] edges) {
        
        dsuf=new ArrayList<>();
        
        for(int i=0;i<edges.length;i++)
            dsuf.add(new Node(-1,0));
        
        for(int[] edge: edges) {
            int from=edge[0]-1,to=edge[1]-1;
            if(find(from)!=find(to))
                union(from,to);
            else
                return edge;
        }
        return new int[0];
    }
    
    int find(int i) {
        if(dsuf.get(i).parent==-1)
            return i;
        return dsuf.get(i).parent=find(dsuf.get(i).parent);
    }
    
    void union(int from,int to) {
        Node a=dsuf.get(find(from)),b=dsuf.get(find(to));
        if(a.rank>b.rank)
            b.parent=from;
        else if(a.rank<b.rank)
            a.parent=to;
        else {
            a.parent=to;
            a.rank++;
        }
    }
}