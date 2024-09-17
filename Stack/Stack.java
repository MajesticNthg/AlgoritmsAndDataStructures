import java.util.*;

public class Stack<T> {
    private LinkedList<T> list;
    private LinkedList<T> minStack;
    private int size;
    private double sum;

    public Stack() {
        this.list = new LinkedList<>();
        this.minStack = new LinkedList<>();
        this.size = 0;
        this.sum = 0;
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

        this.sum += (Integer)val;
        if (minStack.isEmpty() || (Integer)val < (Integer)minStack.peek()) {
            minStack.push(val);
        }
    }

    public T peek () {
        if (this.list.isEmpty()) {
            return null;
        }

        return this.list.peekFirst();
    }
    public T getMin () {
        return minStack.peek();
    }

    public double getAverage () {
        return sum / list.size();
    }
}
