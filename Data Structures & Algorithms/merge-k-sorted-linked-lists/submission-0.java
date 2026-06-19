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
        else if(lists.length == 1) return lists[0];

        for(int i=1; i<lists.length; i++){
            ListNode newNode = merge(lists[i], lists[i-1]);
            lists[i] = newNode;
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
