package coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stack<E> {

    ArrayList<E> elements = new ArrayList<>();

    public void push(E e){
        elements.add(e);
    }

    public E pop() {

        if (elements.isEmpty()) {
            throw new IndexOutOfBoundsException("Can not pop from empty stack!");
        }
        return elements.remove(elements.size() - 1);

    }

    public E peek() {

        if (elements.isEmpty()) {
            throw new IndexOutOfBoundsException("Can not peek at empty stack!");
        }
        return elements.get(elements.size() - 1);
    }

    public static void main(String[] args) {

        char[] array = "string".toCharArray();
        int length = array.length;
        Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
        Character c = map.get(array[0]);

    }
}
