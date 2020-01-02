
(2) Recursive method
Time Complexity: O(N)   Space Complexity: O(N)

class Node {
  int val;
  Node next;
  Node (int x) {val = x;}
}

class RecursiveSolution{
  public static Node reverse(Node curr){
    if(curr==null) {return null;}
    esle if (curr.next == null) {return curr;}
    else {
      Node nextNode = curr.next;
      curr.next = null;
      Node rest = reverse(nextNode);
      nextNode.next = curr;
      return rest;
    }
    
    public static void printList (Node head) {
      while (head!= null){
        System.out.print(head.val + "->")
        head = head.next;
      }
    }
    
    //Driver Code:
    public static void main (String[] args){
        Node list1 = new Node(1);
        list1.next = new Node (2);
        list1.next.next = new Node (3);
        list1.next.next.next= new Node(4);
        System.out.print("Original list:");
        printList(list1);
        System.out.print("\n");
        System.out.print("Reversed list:");
        printList(reverse(list1));

    }
    
  }
}
