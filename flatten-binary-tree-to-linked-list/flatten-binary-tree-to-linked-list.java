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
    public void flatten(TreeNode root) {
        
        if(root==null)
            return;
        Stack<TreeNode> s=new Stack<>();
        
        s.push(root);
        TreeNode i=new TreeNode(0);
        TreeNode j=i;
        
        while(!s.isEmpty()) {
            TreeNode r=s.pop();
            j.right=r;
            if(r.right!=null)
            s.push(r.right);
            if(r.left!=null)
            s.push(r.left);
            r.left=null; r.right=null;
            j=r;
        }
        
        root=i.right;
    }
}