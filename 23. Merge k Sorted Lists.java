https://leetcode.com/problems/merge-k-sorted-lists/submissions/

Given an array of linked-lists lists, each linked list is sorted in ascending order.
Merge all the linked-lists into one sort linked-list and return it.

// Level: Hard   Keywords: PriorityQueue(Min Heap of size K), LinkedList

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
 
// Time Complexity: O(nlogK)?
//Runtime beats 83%, memory beats 60%
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) { return null;}
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, ((a, b) -> (a.val - b.val)));
        
        ListNode dummy = new ListNode(0);
        // pointer
        ListNode tail = dummy;
        
        // First add all list head node to the heap pool
        for(ListNode head: lists){
            if(head!= null){
                pq.add(head);
            }
        }
        
        // The heap is now full, poll out one with min value before adding next
        // while(!pq.isEmpty()){}
        while(pq.size()>0){
            ListNode currMin = pq.poll();
            tail.next = currMin;
            tail = tail.next;

            if(currMin.next != null){
                pq.add(currMin.next);
            }
        }
        
        return dummy.next;
    }
}
