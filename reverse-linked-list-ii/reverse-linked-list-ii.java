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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp=new ListNode(0);
        ListNode prev=temp;
        prev.next=head;
        int l=left;
        while(l-->1)
            prev=prev.next;
        
        ListNode curr=prev.next;
        
        for(int i=0;i<right-left;i++) {
            if(curr.next!=null) {
                ListNode n=curr.next;
                curr.next=n.next;
                n.next=prev.next;
                prev.next=n;
            }
        }
        return temp.next;
    }
}