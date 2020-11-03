Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list. Return the linked list sorted as well.
Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5


public ListNode deleteDuplicates(ListNode head) {
	if(head == null) return null;
	ListNode dummy = new ListNode(0);
	
	ListNode curr = head;
	ListNode prev = dummy;
	ListNode reserve = dummy;
	
	while(curr != null){
		if((prev.val != curr.val || prev == dummy)&&(curr.next ==null || curr.next.val!= curr.val)){
			reserve.next = curr;
			reserve = curr;
		}
		prev = curr;
		curr = curr.next;
	}
	reserve.next = null;
	return dummy.next;
}
