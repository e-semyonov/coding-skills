package coding.linkedlist;

public class TestLinkedList {


    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        ListNode<String> node1 = new ListNode<>("Blue");
        ListNode<String> node2 = new ListNode<>("Red");
        ListNode<String> node3 = new ListNode<>("Green");
        ListNode<String> node4 = new ListNode<>("Yellow");

        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);

        ListNode<String> node = linkedList.get(3);
        System.out.println(node.toString());

        // add, remove from linked list
        System.out.println("LinkedList size = " + linkedList.getSize());
        System.out.println(linkedList);
        // delete head
        linkedList.delete(0);
        System.out.println("After deleting head:");
        System.out.println(linkedList);
        // delete tail
        linkedList.delete(linkedList.getSize() - 1);
        System.out.println("After deleting tail:");
        System.out.println(linkedList);
        linkedList.add(new ListNode<>("Blue"));
        linkedList.addAt(1, new ListNode<>("Purple"));// insert in middle
        linkedList.addAt(0, new ListNode<>("Orange"));// insert at head
        linkedList.addAt(linkedList.getSize(), new ListNode<>("Brown"));
    }

}
