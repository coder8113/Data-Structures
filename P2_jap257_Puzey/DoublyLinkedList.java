// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

//class to represent a doubly linked list
public class DoublyLinkedList {
    Node head;

    /* Method to find a node X and swap it with its successor
       major concept of this algorithm:
          - traverses the linked list to find node x
          - checks if the node has a successor
          - if a successor is found the pointer is adjusted to skip that successor
          - then the previous pointer of the next node is changed to point back to the current node

       the runtime of this algorithm:
          - O(n) where n is the number of nodes in the list
          - this is because in the worst case node x is in the middle of the list
          - the algorithm will have to start traversing at one end of the list
          - n/2 simplifies to a time complexity of O(n)

       Example of running algorithm:
          - shown within the main method
     */

    public void swapWithSuccessor(int x) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        // Find the node X
        while (current != null && current.data != x) {
            current = current.next;
        }

        // If node X is not found
        if (current == null) {
            System.out.println("Node " + x + " not found in the list");
            return;
        }

        // X is at the end of the list, does not have a successor
        if (current.next == null) {
            System.out.println("Node " + x + " is the last node, cannot swap with successor");
            return;
        }

        // Swaps X with its successor
        Node nextNode = current.next;
        Node prevNode = current.prev;

        // Adjust pointers for the successor of x
        current.next = nextNode.next;
        if (nextNode.next != null) {
            nextNode.next.prev = current;
        }

        // Adjust pointers for X
        current.prev = nextNode;
        nextNode.next = current;
        nextNode.prev = prevNode;

        // Adjust pointers for predecessor of x
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode; // If X was the head, update head
        }
    }

    // prints the doubly linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // main method: serves as example of running algorithm
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.head = new Node(25);
        list.head.next = new Node(37);
        list.head.next.prev = list.head;
        list.head.next.next = new Node(40);
        list.head.next.next.prev = list.head.next;
        list.head.next.next.next = new Node(6);
        list.head.next.next.next.prev = list.head.next.next;

        System.out.println("Original list:");
        list.printList();

        int x = 40; // Node to find and swap with its successor
        list.swapWithSuccessor(x);

        System.out.println("List after swapping " + x + " with its successor:");
        list.printList();
    }
}
