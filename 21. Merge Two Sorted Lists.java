Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

public class Solution {
    public static class Node{
        int val;
        Node next;
        Node(int x){this.val = x;}
    }

    public static Node mergeTwoSortedList(Node list1, Node list2){
        Node dummy = new Node(0);
        //pointer to the dummy node
        Node curr = dummy;

        while(list1 !=null && list2 !=null){
            if(list1.val <= list2.val){
                curr.next= list1;
                list1= list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr= curr.next;
        }
        return dummy.next;

    }

    public static void printList(Node head){
        while(head.next!= null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        if(head.next == null){
            System.out.print(head.val);
        }
    }

    public static void main(String[] args) {
	    Node list1 = new Node(1);
        list1.next= new Node(2);
        list1.next.next= new Node(4);

        Node list2 = new Node(1);
        list2.next= new Node(3);
        list2.next.next= new Node(4);

        Node result = mergeTwoSortedList(list1, list2);
        printList(result);

    }
}

