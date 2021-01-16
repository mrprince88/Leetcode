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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return search(cloned,target);
    }
    
    TreeNode search(TreeNode root,TreeNode target) {
        if(root==null)
            return null;
        
        if(root.val==target.val)
            return root;
        
        TreeNode left=search(root.left,target);
        
        return (left==null) ? search(root.right,target) : left;
    }
}
