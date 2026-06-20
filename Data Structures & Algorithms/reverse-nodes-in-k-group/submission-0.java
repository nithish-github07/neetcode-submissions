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
    public ListNode getKth(ListNode node, int k){
        ListNode temp = node;
        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverseList(ListNode head){
        ListNode curr = head, prev = null, after = curr;
        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevtail = dummy, nexthead = null, currtail = null;
        while (true){
            ListNode kth = getKth(prevtail, k);
            if(kth == null) break;
            nexthead = kth.next;
            currtail = prevtail.next;

            kth.next = null;
            ListNode reversedhead = reverseList(prevtail.next);
            prevtail.next = reversedhead;
            currtail.next = nexthead;

            prevtail = currtail;
        }

        return dummy.next;
    }
}
