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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return equals(root.left,root.right);
    }
    
    
    boolean equals(TreeNode n,TreeNode m) {
        if(n==null && m==null)
            return true;
        
        if((n==null && m!=null) || (n!=null && m==null) || n.val!=m.val)
            return false;
        return equals(n.left,m.right) && equals(n.right,m.left);
    }
}