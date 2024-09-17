import java.util.*;

public class Queue<T> {
    private LinkedList<T> list;
    private int size;

    public Queue() {
        this.list = new LinkedList<>();
        this.size = 0;
    }

    public void enqueue(T item) {
        this.list.addLast(item);
        this.size++;
    }

    public T dequeue() {
        if (this.list.isEmpty()) {
            return null;
        }
        this.size--;

        return this.list.removeFirst();
    }

    public int size() {
        return this.list.size();
    }
}
