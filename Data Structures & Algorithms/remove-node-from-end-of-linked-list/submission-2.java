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
        ListNode temp1 = null, temp2 = head;
        for(int i=1; i<n; i++){
            temp2 = temp2.next;
        }
        while(temp2.next != null){
            if(temp1 == null) temp1 = head;
            else temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1 != null && temp1.next.next == null){
            temp1.next = null;
        }
        else if(temp1 == null){
            temp1 = head;
            head = temp1.next;
            temp1 = null;
        }
        else{
            temp1.next = temp1.next.next;
        }
        return head;
    }
}
