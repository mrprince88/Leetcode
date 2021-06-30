/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    Map<Integer,Node> map;
    public Node cloneGraph(Node node) {
        map=new HashMap<>();
        return dfs(node);
    }
    
    Node dfs(Node node) {
        if(node==null) return null;
        
        if(map.containsKey(node.val)) return map.get(node.val);
        
        Node n=new Node(node.val);
        map.put(n.val,n);
        
        for(Node i:node.neighbors)
            n.neighbors.add(dfs(i));
        
        return n;
    }
}