import java.util.*;
public class Stack<T> {
    private LinkedList<T> list;
    private int size;

    public Stack() {
        this.list = new LinkedList<>();
        this.size = 0;
    }

    public int size() {
        return this.list.size();
    }

    public T pop () {
        if (this.list.isEmpty()) {
            return null;
        }
        this.size--;

        return this.list.removeFirst();
    }

    public void push (T val) {
        this.list.addFirst(val);
        this.size++;
    }

    public T peek () {
        if (this.list.isEmpty()) {
            return null;
        }

        return this.list.peekFirst();
    }
}