import java.util.*;

class MinStack {
    private LinkedList<Integer> list;
    private int size;

    public MinStack () {
        this.list = new LinkedList<>();
        this.size = 0;

    }
    public int size() {
        return list.size();
    }

    public void push(int value) {
        if (list.isEmpty() || value <= list.peekFirst()) {
            list.addFirst(value);
        }
        this.size++;
    }

    public void pop(int value) {
        if (!list.isEmpty() && value == list.peekFirst()) {
            list.removeFirst();
        }
        this.size--;
    }

    public int peek () {
        if (this.list.isEmpty()) {
            throw new NullPointerException("Error - stack is empty");
        }

        return this.list.peekFirst();
    }

    public int getMin() {
        return list.peekFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class Stack<T> {
    private LinkedList<T> list;
    private MinStack minStack = new MinStack();
    private int size;
    private double sum;

    public Stack() {
        this.list = new LinkedList<>();
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
        if (minStack.size() == 0 || (Integer)val < (Integer)minStack.peek()) {
            minStack.push((Integer)val);
        }
    }

    public T peek () {
        if (this.list.isEmpty()) {
            return null;
        }

        return this.list.peekFirst();
    }
    public int getMin () {
        return minStack.peek();
    }

    public double getAverage () {
        return sum / list.size();
    }
}
