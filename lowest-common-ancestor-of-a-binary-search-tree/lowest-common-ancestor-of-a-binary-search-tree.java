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
        int parent=root.val,pVal=p.val,qVal=q.val;
        if(p.val>parent && q.val>parent)
            return lowestCommonAncestor(root.right,p,q);
        else if(pVal<parent && qVal<parent)
            return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}