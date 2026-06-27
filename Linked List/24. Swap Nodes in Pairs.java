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
    public void reverse(ListNode head, int size) {
        ListNode curr = head;
        ListNode prev = null;
        for (int i = 0; i < size; i++) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
    }

    public ListNode swapPairs(ListNode head) {
        int size = 2;
        ListNode left = head;
        ListNode right;
        ListNode prevLeft = null;
        ListNode res = null;

        if (head == null || head.next == null) {
            return head;
        }

        while (true) {
            right = left;
            for (int i = 1; i < size; i++) {
                if (right == null) {
                    break;
                }
                right = right.next;
            }

            if (right != null) {
                ListNode nextLeft = right.next;
                reverse(left, size);
                if (prevLeft != null) {
                    prevLeft.next = right;
                } else {
                    res = right;
                }
                prevLeft = left;
                left = nextLeft;
                if (left == null) {
                    break;
                }
            } else {
                break;
            }
        }
        if (prevLeft != null) {//odd number of nodes no right is there.
            prevLeft.next = left;
        }
        return res;

    }
}
