package coding.linkedlist;

public class DoublyLinkedList<E> {

    private ListNodeDoubly<E> head;
    private ListNodeDoubly<E> tail;
    private int size = 0;

    public DoublyLinkedList() {

    }

    public int getSize() {
        return size;
    }


    // insert at the end
    public void add(ListNodeDoubly<E> node) {
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.prev = this.tail;// the two first arrows order is not a must but the last one must be this.tail = node
            this.tail.next = node;
            this.tail = node;
        }

        this.size++;
    }

    // insert at the front
    public void addAtFront(ListNodeDoubly<E> node) {
        // clear node's previous pointers
        node.next = null;
        node.prev = null;
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        this.size++;
    }

    // delete at the end
    public void deleteAtEnd() {
        if(this.size == 0) {
            throw new IndexOutOfBoundsException("Can not remove from empty list!");
        }
        if (this.size == 1) {

            this.tail = null;
            this.head = null;
            this.size = 0;
            return;
        }
        ListNodeDoubly<E> oldTail = this.tail;
        this.tail = this.tail.prev;
        this.tail.next = null;
        oldTail.prev = null;
        this.size--;
    }

    // delete at front
    public void deleteAtFront() {
        if(size == 0) {
            throw new IndexOutOfBoundsException("Can not remove from empty list!");
        }
        if (size == 1) {
            this.tail = null;
            this.head.prev = null;
            this.head.next = null;
            this.head = null;
            this.size = 0;
            return;
        }
        ListNodeDoubly<E> oldNode = this.head;
        this.head = this.head.next;
        this.head.prev = null;
        oldNode.next = null;
        this.size--;
    }
}
