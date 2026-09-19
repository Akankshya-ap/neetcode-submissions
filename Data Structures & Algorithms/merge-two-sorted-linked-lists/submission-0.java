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
        ListNode curr = new ListNode();
        ListNode list3= curr;
        ListNode temp;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                temp = new ListNode(list2.val);
                list2 = list2.next;
            }
            curr.next = temp;
            curr = temp;

            if(list3==null){
                System.out.print("check");
                list3 = curr.next;
            }
        }

        while(list1!=null){
            temp = new ListNode(list1.val);
            curr.next = temp;
            curr = temp;
            list1 = list1.next;
            if(list3==null){
                list3 = curr.next;
            }
        }
        while(list2!=null){
            temp = new ListNode(list2.val);
            curr.next = temp;
            curr = temp;
            list2 = list2.next;
            if(list3==null){
                list3 = curr.next;
            }
        }

        return list3.next;
    }
}