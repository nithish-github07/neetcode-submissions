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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        while(lists.length > 1){
            int k = 0;
            ListNode[] merged = new ListNode[(lists.length + 1) / 2];
            for(int i=0; i<lists.length; i+=2){
                ListNode list1 = lists[i];
                ListNode list2 = ((i + 1) < lists.length) ? lists[i + 1] : null;
                merged[k++] = merge(list1, list2);
            }
            lists = merged;
        }

        return lists[lists.length - 1];
    }
    public ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        else if(list2 == null) return list1;

        ListNode p = list1, q = list2;
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(p != null && q != null){
            if(p.val <= q.val){
               tail.next = p;
               p = p.next; 
            }
            else{
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }

        if(p != null) tail.next = p;
        else if(q != null) tail.next = q;

        return head.next;
    }
}
