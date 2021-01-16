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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null && l2==null)
            return null;
        
        if(l1==null && l2!=null)
            return l2;
        
        if(l1!=null && l2==null)
            return l1;
        
        ListNode i=l1,j=l2,prev=null;
        
        while(i!=null && j!=null) {
            if(i.val<j.val) {
                prev=i;
                i=i.next; 
            }
            else {
                if(prev!=null) {
                    prev.next=j;
                }
                prev=j;
                j=j.next;
                prev.next=i;
            }
        }
        if(i==null)
            prev.next=j;
        
        if(l1.val<l2.val)
            return l1;
        else
            return l2;
    }
}
