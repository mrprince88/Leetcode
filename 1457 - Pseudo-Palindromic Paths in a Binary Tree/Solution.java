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
    
    public int pseudoPalindromicPaths (TreeNode root) {
        solve(root,0);
        return counter;
    }
    
    int counter=0;
    
    void solve(TreeNode root,int curr) {
        
        if(root==null) {
            return;
        }
        
        curr^=(1<<root.val);
        
                      
        if(root.left==null && root.right==null) {
            if((curr&(curr-1))==0)
                counter++;
        }
        
        else {
            solve(root.left,curr);
            solve(root.right,curr);
        }
    }
}
