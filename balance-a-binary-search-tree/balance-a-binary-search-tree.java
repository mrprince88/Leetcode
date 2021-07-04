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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);
        return createTree(list,0,list.size()-1);
    }
    
    void inOrder(TreeNode root,List<Integer> list) {
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    
    TreeNode createTree(List<Integer> list,int l,int r) {
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode newNode=new TreeNode(list.get(mid));
        newNode.left=createTree(list,l,mid-1);
        newNode.right=createTree(list,mid+1,r);
        return newNode;
    }
    
}