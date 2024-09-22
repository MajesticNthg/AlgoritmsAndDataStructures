import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    Queue<Integer> list = new Queue<>();

    @Test
    public void turnQueue() {
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);
        list.enqueue(6);
        list.enqueue(7);

        assertEquals(3, list.dequeue());
    }

    @Test
    public void reverseQueue() {
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);
        list.enqueue(6);
        list.enqueue(7);

        list.reverseQueue(this.list);
        assertEquals(7, list.dequeue());
        assertEquals(6, list.dequeue());
    }
}
