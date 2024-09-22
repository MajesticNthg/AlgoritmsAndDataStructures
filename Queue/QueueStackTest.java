import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueStackTest {
    QueueStack<Integer> list = new QueueStack<>();

    @Test
    public void stackSize() {
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);
        list.enqueue(6);

        assertEquals(4, list.size());
        list.dequeue();
        assertEquals(3, list.size());
    }

    @Test
    public void dequeueTest() {
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);
        list.enqueue(6);

        assertEquals(3, list.dequeue());
        assertEquals(4, list.dequeue());
    }

    @Test
    public void addAndDelete() {
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);

        assertEquals(1, list.dequeue());
        list.enqueue(8);
        list.enqueue(9);
        list.enqueue(4);
        assertEquals(2, list.dequeue());
        assertEquals(3, list.dequeue());
        assertEquals(4, list.dequeue());
        assertEquals(5, list.dequeue());
        assertEquals(8, list.dequeue());
    }
}