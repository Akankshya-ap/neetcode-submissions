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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode groupPrev = start;

        while(true){
            ListNode kth = getKthNodeFromCurrent(groupPrev, k);
            if(kth == null) break;

            ListNode groupNext = kth.next;
            ListNode prev = groupNext, curr = groupPrev.next;

            while(curr!=groupNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;


        }
        return start.next;
    }

    ListNode getKthNodeFromCurrent(ListNode curr, int k){
        while(curr!=null && k-->0) curr = curr.next;
        return curr;

    }
}
