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
    List<Integer> list;
    public TreeNode balanceBST(TreeNode root) {
        list=new ArrayList<>();
        inOrder(root);
        return createTree(0,list.size()-1);
    }
    
    void inOrder(TreeNode root) {
        if(root==null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    
    TreeNode createTree(int l,int r) {
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode newNode=new TreeNode(list.get(mid));
        newNode.left=createTree(l,mid-1);
        newNode.right=createTree(mid+1,r);
        return newNode;
    }
    
}