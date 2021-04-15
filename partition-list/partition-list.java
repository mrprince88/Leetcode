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
    public ListNode partition(ListNode head, int x) {
        ListNode before_head=new ListNode(0),after_head=new ListNode(0);
        ListNode idx1=before_head,idx2=after_head;
        
        while(head!=null) {
            if(head.val<x) {
                idx1.next=head;
                idx1=idx1.next;
            }
            else {
                idx2.next=head;
                idx2=idx2.next;
            }
            head=head.next;
        }
        idx2.next=null;
        idx1.next=after_head.next;
        
        return before_head.next;
        
    }
}