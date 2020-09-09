Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

// Iterative 3 pointers (prev, head/curr, next(for storing))

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null){
            // store the next node first
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
