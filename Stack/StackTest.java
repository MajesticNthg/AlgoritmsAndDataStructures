import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack <Integer> myStack = new Stack<>();

    @Test
    void size() {
        assertEquals(0, myStack.size());

        myStack.push(3);
        myStack.push(4);
        assertEquals(2, myStack.size());
        assertEquals(4, myStack.pop());
        assertEquals(3, myStack.pop());
        assertEquals(0, myStack.size());
    }

    @Test
    void pop() {
        assertNull(myStack.pop());

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.pop());
        assertEquals(2, myStack.pop());
    }

    @Test
    void push() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(8);
        assertEquals(3, myStack.size());
        assertEquals(8, myStack.peek());

    }

    @Test
    void peek() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(8);
        assertEquals(8, myStack.peek());
        myStack.push(5);
        assertEquals(5, myStack.peek());
    }

    @Test
    void checkNull () {
        myStack.push(1);
        assertEquals(1, myStack.size());
        myStack.pop();
        assertNull(myStack.pop());
    }


    @Test
    void minAndMeanStackTest () {
        myStack.push(3);
        myStack.push(4);
        myStack.push(8);
        assertEquals(3, myStack.getMin());
        myStack.push(1);
        assertEquals(1, myStack.getMin());
        assertNotEquals(3, myStack.getMin());
        myStack.push(3);
        assertEquals(3.8, myStack.getAverage());
        myStack.push(8);
        assertEquals(4.5, myStack.getAverage());
    }

    @Test
    void minStackNull () {
        assertNull(myStack.getMin());
    }
}

