/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    
    private TreeNode toBST(ListNode head,ListNode tail) {
        ListNode fast=head,slow=head;
        
        if(head==tail)
            return null;
        
        while(fast!=tail && fast.next!=tail) {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        TreeNode temp=new TreeNode(slow.val);
        temp.left=toBST(head,slow);
        temp.right=toBST(slow.next,tail);
        return temp;
    }
}