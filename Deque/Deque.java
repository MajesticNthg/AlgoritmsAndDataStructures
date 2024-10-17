import java.util.*;

public class Deque<T> {
    private LinkedList<T> list;
    private int size;
    private ArrayList<Integer> min;

    public Deque() {
        this.list = new LinkedList<>();
        this.size = 0;
        this.min = new ArrayList<>();
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
        return deleteMin(this.list.removeFirst());
    }

    public T removeTail() {
        if (this.list.isEmpty()) {
            return null;
        }

        this.size--;

        return deleteMin(this.list.removeLast());
    }

    public int size() {
        return this.list.size();
    }
    private T deleteMin (T item) {
        this.min.remove(item);
        return item;
    }

    private void addMin (T item) {
        if (this.min.isEmpty()) {
            this.min.add((Integer)item);
            return;
        }

        if ((Integer)item <= this.min.getLast()) {
            this.min.add((Integer)item);
            return;
        }

        if ((Integer)item > this.min.getLast()) {
            addCorrect(item);
        }
    }
    private void addCorrect (T item) {
        for (int x = 0; x < this.min.size(); x++) {
            if (this.min.get(x) < (Integer)item) {
                this.min.add(x, (Integer)item);
                return;
            }
        }
    }

    public int getMin (Deque deq) {
        return this.min.getLast();
    }
}
