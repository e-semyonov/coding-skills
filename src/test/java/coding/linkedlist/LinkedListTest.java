package coding.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTest {

    @Test
    void addGetDeleteAndAddAtWorkAsExpected() {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add(new ListNode<>("Blue"));
        linkedList.add(new ListNode<>("Red"));
        linkedList.add(new ListNode<>("Green"));

        assertEquals(3, linkedList.getSize());
        assertEquals("Blue", linkedList.get(0).value);
        assertEquals("Red", linkedList.get(1).value);
        assertEquals("Green", linkedList.get(2).value);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
        linkedList.delete(1);
        assertEquals(2, linkedList.getSize());
        assertEquals("Blue", linkedList.get(0).value);
        assertEquals("Green", linkedList.get(1).value);

        linkedList.addAt(1, new ListNode<>("Purple"));
        assertEquals(3, linkedList.getSize());
        assertEquals("Blue", linkedList.get(0).value);
        assertEquals("Purple", linkedList.get(1).value);
        assertEquals("Green", linkedList.get(2).value);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
    }
}
