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
    
    private int ans;
    
    public int minCameraCover(TreeNode root) {
        ans=0;
        if(dfs(root)==0)
            ++ans;
        return ans;
    }
    
    private int dfs(TreeNode node) {
        
        if(node==null) return 2;
        
        int left=dfs(node.left);
        int right=dfs(node.right);
            
        if(left==0 || right==0) {
            ans++;
            return 1;
        }
        else if(left==2 && right==2) {
            return 0;
        }
        else return 2;
    }
}