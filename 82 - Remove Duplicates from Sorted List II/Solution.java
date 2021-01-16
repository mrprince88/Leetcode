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
    public ListNode deleteDuplicates(ListNode head) {
        return solve(head);
    }
    
    ListNode solve(ListNode head) {
        
        ListNode ans=new ListNode(0,head),i=head;
        ListNode prev=ans;
        
        while(i!=null) {
            
            if(i.next!=null && i.val==i.next.val) {
                while(i.next!=null && i.val==i.next.val)
                    i=i.next;
                prev.next=i.next;
            }
            else
                prev=prev.next;
            
            i=i.next;
        }
        
        return ans.next;
    } 
}
