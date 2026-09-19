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
        int count = 0;
        ListNode end = head;
        while(end!=null){
            count++;
            end = end.next;
        }

        int k = count-n;

        if(k==0) return head.next;

        ListNode temp = head;
        ListNode prev = null;
        while(k>0){
            prev = temp;
            temp = temp.next;
            k--;
        }

        
        if(temp.next!=null) prev.next = temp.next;
        else prev.next = null;
        return head;
        

    }
}
