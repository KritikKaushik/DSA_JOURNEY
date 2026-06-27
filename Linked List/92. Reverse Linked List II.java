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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right || head==null){
            return head;
        }

        ListNode temp=head;
        ListNode before=null;


        for(int pos=1;pos<left;pos++){
            before=temp;
            temp=temp.next;
        }
        ListNode curr=temp;
        ListNode prev=null;

        int revTime=right-left+1;

        for(int j=0;j<revTime;j++){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        
        temp.next=curr;
        if(before!=null){
            before.next=prev;
            return head;
        }
        
        return prev;

        
    }
}
