import java.util.*;

public class Deque<T> {
    private LinkedList<T> list;
    private int size;
    private Stack<Integer> min;

    public Deque() {
        this.list = new LinkedList<>();
        this.size = 0;
        this.min = new Stack<>();
    }

    public void addFront(T item) {
        this.list.addFirst(item);
        this.size++;
        addMin(item);
    }

    public void addTail(T item) {
        this.list.addLast(item);
        this.size++;
        addMin(item);
    }

    public T removeFront() {
        if (this.list.isEmpty()) {
            return null;
        }

        this.size--;

        return this.list.removeFirst();
    }

    public T removeTail() {
        if (this.list.isEmpty()) {
            return null;
        }

        this.size--;

        return this.list.removeLast();
    }

    public int size() {
        return this.list.size();
    }

    public void addMin (T item) {
        if (this.min.isEmpty()) {
            this.min.push((Integer)item);
            return;
        }

        if ((Integer)item < this.min.peek()) {
            this.min.pop();
            this.min.push((Integer)item);
            return;
        }
    }

    public int getMin (Deque deq) {
        return this.min.peek();
    }
}
