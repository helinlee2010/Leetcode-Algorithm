19. Remove Nth Node From End of List (Medium)

Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid. Could you do this in one pass?

Method: using two pointers- slow & fast

class Node{
    int val;
    Node next;
    Node (int x) {val = x;}
}

class Solution {
    public static Node deleteKThFromEnd (int k, Node head){
        Node dummy = new Node (0);
        Node slow = dummy, fast = dummy;
        dummy.next = head;
        
        if (head ==null) {return null;}
        if (k<0) {return null;}
        //what if (k>length of the list?)
        
        //Advance fast pointer k steps ahead of slow pointer first
        for (int i=0; i<k; i++){
            fast = fast.next;
        }
        
        //Then move slow&fast pointers at same pace until fast reaches the end of list
        while (fast.next != null) {
            slow= slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return dummy.next;
    }
    

    public static void printList(Node head){
            while (head !=null){
            System.out.print(head.val);
                if (head.next != null) {
                    System.out.print("->");
                }
            head = head.next;
            }
    }
    
    public static void main (String[] args){
        Node list1 = new Node(1);
        list1.next = new Node (2);
        list1.next.next = new Node (3);
        list1.next.next.next= new Node(4);
        System.out.print("Original list:");
        printList(list1);
        System.out.print("\n");
        System.out.print("Revised list:");
        printList(deleteKThFromEnd(2,list1));
    }
}
