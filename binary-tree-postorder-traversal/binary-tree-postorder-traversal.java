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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        LinkedList<Integer> list=new LinkedList<>();
        while(!stack.isEmpty()) {
            TreeNode n=stack.pop();
            if(n!=null) {
            list.addFirst(n.val);
            stack.push(n.left);
            stack.push(n.right);
            }
        }
        return list;
    }
}