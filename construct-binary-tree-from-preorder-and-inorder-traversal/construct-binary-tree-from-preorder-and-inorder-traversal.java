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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder,inorder,Integer.MIN_VALUE);    
    }
    
    int pre=0,in=0;
    
    TreeNode solve(int[]  preorder,int[] inorder,int end) {
        if(pre==preorder.length)
            return null;
        
        if(inorder[in]==end) {
            in++;
            return null;
        }
        TreeNode node=new TreeNode(preorder[pre++]);
        node.left=solve(preorder,inorder,node.val);
        node.right=solve(preorder,inorder,end);
        return node;
    }
}