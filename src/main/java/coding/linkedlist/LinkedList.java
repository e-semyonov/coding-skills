package coding.linkedlist;

public class LinkedList<E> {

    //  Time Complexity
    //  Operation 	Big-O Time Complexity 	Note
    //  Access 	    O(n)
    //  Search 	    O(n)
    //  Insertion 	O(1)* 	Assuming you already have a reference to the node at the desired position
    //  Deletion 	O(1)* 	Assuming you already have a reference to the node at the desired position
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size = 0;

    LinkedList() {

    }

    public void add(ListNode<E> node) {

        if (size == 0) {
            this.head = node;
            this.tail = node;
            size++;
        } else {
            this.tail.next = node;
            this.tail = node;
            size++;
        }
    }

    // get nth node in the list
    public ListNode<E> get(int n) {
        int runningIndex = 0;
        ListNode<E> current = this.head;
        if (n >= this.size) {
            throw new IndexOutOfBoundsException("Index " + n + " is out of bounds for size " + this.size);
        }
        while (n > runningIndex) {
            runningIndex++;
            current = current.next;
        }
        return current;
    }

    public void delete(int n) {
        if (n >= this.size) {
            throw new IndexOutOfBoundsException("Can not remove nth element from list of size " + this.size);
        }

        // special cases
        // n = 0
        if (n == 0) {
            this.head = this.head.next;
            this.size--;
            return;
        }

        // find
        ListNode<E> previousElementToN = this.head;
        int index = 0;
        while(n-1 > index) { //  need to find the previous to the element to be removed
            previousElementToN = previousElementToN.next;
            index++;
        }
        // tail?
        if (n == this.size - 1) {
            this.tail = previousElementToN;
        }
        // remove - jump over the removed element and chain the linked list over nth element
        previousElementToN.next = previousElementToN.next.next;
        this.size--;

    }

    public void addAt(int n, ListNode<E> node) {

        if (n > this.size) {
            throw new IndexOutOfBoundsException("Can not add to the " + n + "th place, size = " + this.size);
        }
        int i = 0;
        ListNode<E> nodeBefore = this.head;
        if ( n == 0) {
            node.next = this.head;
            this.head = node;
            this.size++;
            return;
        }
        while (i < n - 1) {
            nodeBefore = nodeBefore.next;
            i++;
        }
        // insert
        node.next = nodeBefore.next;
        nodeBefore.next = node;
        this.size++;
    }


    public ListNode<E> getHead() {
        return head;
    }

    public ListNode<E> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
