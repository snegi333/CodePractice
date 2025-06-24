public class CustomLinkedList {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Add element at end
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Get element at index
    public int get(int index) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            current = current.next;
            count++;
        }

        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
    }

    // Remove element at index
    public void remove(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty.");
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        int count = 0;

        while (current.next != null && count < index - 1) {
            current = current.next;
            count++;
        }

        if (current.next == null) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }

        current.next = current.next.next;
    }

    // Print all elements
    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.printList();  // Output: 10 -> 20 -> 30 -> null

        System.out.println("Element at index 1: " + list.get(1));  // Output: 20

        list.remove(1);
        list.printList();  // Output: 10 -> 30 -> null
    }
}