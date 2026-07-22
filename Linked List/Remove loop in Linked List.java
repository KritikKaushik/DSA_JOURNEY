/* Structure of linked list Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */
class Solution {
    public static void removeLoop(Node head) {
        // code here
        if(head==null || head.next==null){
            return;
        }
        Node slow=head;
        Node fast=head;
        boolean hasCycle=false;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                hasCycle=true;
                break;
            }
        }
        if(!hasCycle){
            return;
        }
        
        slow=head;
        if(slow==fast){
            while(fast.next!=slow){
                fast=fast.next;
            }
            fast.next=null;
            return;
        }
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }
}
