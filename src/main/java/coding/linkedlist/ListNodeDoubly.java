package coding.linkedlist;

public class ListNodeDoubly<E> {

    E value;
    ListNodeDoubly<E> next;
    ListNodeDoubly<E> prev;

    ListNodeDoubly(E value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
