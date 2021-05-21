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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            List<Integer> subList=new ArrayList<>();
            int num=q.size();
            
            while(num-->0) {
                TreeNode n=q.poll();
                subList.add(n.val);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            list.add(subList);
        }
        return list;
    }
}