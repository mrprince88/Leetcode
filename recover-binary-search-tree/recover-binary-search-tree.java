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
    public void recoverTree(TreeNode root) {
        TreeNode prev=null,first=null,second=null,temp=null;
        
        while(root!=null) {
            if(root.left==null) {
                if(prev!=null && prev.val>root.val) {
                    if(first==null) first=prev;
                    second=root;
                }
                prev=root;
                root=root.right;
            }
            
            else {
                temp=root.left;
                while(temp.right!=null && temp.right!=root)
                    temp=temp.right;
                if(temp.right!=null) {
                    if(prev!=null && prev.val>root.val) {
                        if(first==null) first=prev;
                            second=root;
                    }
                    prev=root;
                    temp.right=null;
                    root=root.right;
                }
                else {
                    temp.right=root;
                    root=root.left;
                }
            }
        }
        
        if(first!=null && second!=null) {
            int t=first.val; first.val=second.val; second.val=t;
        }
    }
}