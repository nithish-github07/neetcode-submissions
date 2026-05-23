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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode sorted = new ListNode(); 
        ListNode p = list1, q = list2;
        if(p != null && q != null){
            if(p.val <= q.val){
                sorted = p;
                p = p.next;
            }
            else{
                sorted = q;
                q = q.next;
            }
        }
        ListNode temp = sorted;
        while(p != null && q != null){
            if(p.val <= q.val){
                temp.next = p;
                p = p.next;
                temp = temp.next;
            }
            else{
                temp.next = q;
                q = q.next;
                temp = temp.next;
            }
        }

        if(p != null) temp.next = p;
        else if(q != null) temp.next = q;

        return sorted;

    }
}