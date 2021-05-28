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
    
    int maxDepth=0,sum=0;
    
    void solve(TreeNode root,int depth) {
        if(root==null) {
            return;
        }
        
        if(depth>=maxDepth) {
            sum=(depth==maxDepth) ? sum+root.val:root.val;
            maxDepth=depth;
        }
        solve(root.left,depth+1);
        solve(root.right,depth+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        solve(root,0);
        return sum;
    }
}