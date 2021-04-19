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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1=dummy,p2=dummy;
        int c=0;
        
        while(c++!=n+1) {
            p2=p2.next;
        }
        
        while(p2!=null) {
            p1=p1.next;
            p2=p2.next;
        }
        
        p1.next=p1.next.next;
        return dummy.next;
    }
}