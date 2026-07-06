package coding.linkedlist;

public class ListNode<E> {

    E value;
    ListNode<E> next;

    ListNode(E value){
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
