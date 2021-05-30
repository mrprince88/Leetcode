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
    int max;
    public int maxDepth(TreeNode root) {
        max=0;
        if(root==null)
            return max;
        dfs(root,1);
        return max;
    }
    
    void dfs(TreeNode n,int depth) {
        if(n==null)
            return;
        
        max=Math.max(max,depth);
        dfs(n.left,depth+1);
        dfs(n.right,depth+1);
    }
}