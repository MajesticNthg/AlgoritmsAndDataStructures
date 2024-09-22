import java.util.*;

public class Deque<T> {
    private LinkedList<T> list;
    private int size;

    public Deque() {
        this.list = new LinkedList<>();
        this.size = 0;
    }

    public void addFront (T item) {
        this.list.addFirst(item);
        this.size++;
    }

    public void addTail (T item) {
        this.list.addLast(item);
        this.size++;
    }

    public T removeFront () {
        if (this.list.isEmpty()) {
            return null;
        }

        this.size--;

        return this.list.removeFirst();
    }

    public T removeTail () {
        if (this.list.isEmpty()) {
            return null;
        }

        this.size--;

        return this.list.removeLast();
    }

    public int size () {
        return this.list.size();
    }

}
