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
    public boolean isPalindrome(ListNode head) {
        
        ListNode fast=head,slow=head;
        
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        if(fast!=null)
            slow=slow.next;
        
        ListNode revList=reverseList(slow);
        
        while(revList!=null && revList.val==head.val) {
            revList=revList.next; head=head.next;
        }
        return revList==null;
    }
    
    ListNode reverseList(ListNode head) {
		ListNode p1 = null, p2 = head, p3;
		while (p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		head = p1;
        return p1;
	}
}