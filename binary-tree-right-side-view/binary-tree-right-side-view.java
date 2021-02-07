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
    public List<Integer> rightSideView(TreeNode root) {   
        List<Integer> list=new ArrayList<>();    
        if(root==null)
            return list;  
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root); 
        while(!queue.isEmpty()) {
            int size=queue.size();
            int quSize=queue.size();
            
            while(size>0) {
                
                TreeNode head=queue.poll();
                
                if(size==quSize)
                    list.add(head.val);
                
                if(head.right!=null)
                    queue.offer(head.right);
                
                if(head.left!=null)
                    queue.offer(head.left);
                
                size--;
            }
            
        }
        return list;
    }
}