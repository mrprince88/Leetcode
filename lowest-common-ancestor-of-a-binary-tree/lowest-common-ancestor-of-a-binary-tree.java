/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root,p,q);
    }
    
    TreeNode LCA(TreeNode root,TreeNode p,TreeNode q) {
        if(root==null)
            return null;
        
        if(root.equals(p) || root.equals(q))
            return root;
        
        TreeNode left=LCA(root.left,p,q),right=LCA(root.right,p,q);
        
        if(left!=null && right!=null)
            return root;
        
        return (left!=null) ?  left: right;
    }
}