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
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }



    public void reorderList(ListNode head) {
        if(head==null){
            return ;
        }

        ListNode slow=head;
        ListNode fast=head;

        //3 steps 

        //middle

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //Reverse Linked list
        ListNode revHead=reverse(slow.next);
        slow.next=null;
        //Merge alternatively

        ListNode first=head;

        while(revHead!=null){
            ListNode temp=first.next;
            ListNode revtemp=revHead.next;

            first.next=revHead;
            revHead.next=temp;

            first=temp;
            revHead=revtemp;
        }

    }
}
