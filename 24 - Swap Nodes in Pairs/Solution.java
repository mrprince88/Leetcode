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
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode index=head;
        
        while(index!=null && index.next!=null) {
            int temp=index.val;
            index.val=index.next.val;
            index.next.val=temp;
            index=index.next.next;
        }
        
        return head;
            
    }
}
