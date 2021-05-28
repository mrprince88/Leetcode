/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    PriorityQueue<int[]> pq;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];
            else if (a[0] != b[0])
                return a[0] - b[0];
            else
                return a[2] - b[2];
        });
        
        List<List<Integer>> list=new ArrayList<>();
        
        inOrder(root,0,0);
        
        int prev=-1;
        
        while(!pq.isEmpty()) {
            int []curr=pq.poll();
            if(list.isEmpty()|| curr[1]!=prev)
                list.add(new ArrayList<Integer>());
            prev=curr[1];
            list.get(list.size()-1).add(curr[2]);
        }
        
        return list;
    }
    
    void inOrder(TreeNode root,int row,int col) {
        if(root==null)
            return;
        inOrder(root.left,row+1,col-1);
        pq.add(new int[]{row,col,root.val});
        inOrder(root.right,row+1,col+1);
    }
}