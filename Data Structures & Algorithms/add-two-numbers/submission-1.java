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
        long n1 = getNumber(l1);
        long n2 = getNumber(l2);

        long n = n1+n2;
        if(n==0) return new ListNode(0);

        ListNode head = new ListNode();
        ListNode prev = head;
        while(n>0){
            int t = (int)(n%10);
            ListNode temp = new ListNode(t);
            n = n/10;
            prev.next = temp;
            prev = temp;
        }   
        return head.next;

    }

    private long getNumber(ListNode l){
        if(l==null) return 0;

        ListNode curr = l;

        long res = 0;
        int k =0;
        while(curr!=null)
        {
            res = res + (long)(curr.val * Math.pow(10,k));
            k++;
            curr = curr.next;   
        }

        return res;
    }
}
