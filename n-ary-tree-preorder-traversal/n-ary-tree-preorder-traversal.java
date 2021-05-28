/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        
        Stack<Node> s=new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()) {
            Node i=s.pop();
            List<Node> children=i.children;
            list.add(i.val);
            for(int j=children.size()-1;j>=0;j--)
                s.push(children.get(j));
        }
        return list;
    }
}