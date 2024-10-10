import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void addFront() {
    }

    @Test
    void addTail() {
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeTail() {
    }

    @Test
    void size() {
    }

    @Test
    void testIsPalindrome() {
        // assertTrue(Deque.isPalindrome("шалаш"));
        // assertFalse(Deque.isPalindrome("шалашик"));
    }

    @Test
    void addMin() {
    }

    @Test
    void getMinDeque() {
        Deque<Integer> deque = new Deque<>();

        deque.addFront(3);
        deque.addFront(4);
        deque.addFront(4);
        deque.addFront(6);
        deque.addFront(5);

        assertEquals(3, deque.getMin(deque));
    }
}