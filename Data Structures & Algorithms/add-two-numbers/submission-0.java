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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode temp = null;
        ListNode temp1 = l1, temp2 = l2;
        int sum = 0;
        int carry = 0;
        while(temp1 != null|| temp2 != null || carry != 0){
            int val1 = (temp1 != null) ? temp1.val : 0;
            int val2 = (temp2 != null) ? temp2.val : 0;
            sum = carry + val1 + val2;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            if(res == null){
                res = newNode;
                temp = res;
            }
            else{
                temp.next = newNode;
                temp = temp.next;
            }
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        return res;
    }
}
