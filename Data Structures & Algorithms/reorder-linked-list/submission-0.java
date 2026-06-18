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
    public ListNode reverseList(ListNode head){
        ListNode curr = head, prev = null, after = null;
        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) return;
        ListNode slow = head, fast = head;
        ListNode temp = null;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode mid = slow;
        ListNode reversed = reverseList(mid);

        ListNode p = head, q = reversed;
        ListNode p_next, q_next;
        while(p!=null){
            p_next = p.next;
            q_next = q.next;

            p.next = q;
            if(p_next != null) q.next = p_next;
            else q.next = q_next;

            p = p_next;
            q = q_next;
        }
        
        if(q != null) q.next = null;
        return;
    }
}
