import java.util.*;

public class QueueStack<T> {
    private Stack<T> stackFirst;
    private Stack<T> stackSecond;


    public QueueStack() {
        stackFirst = new Stack<>();
        stackSecond = new Stack<>();
    }

    public void enqueue(T item) {
        stackFirst.push(item);
    }

    public T dequeue() {
        if (!stackSecond.isEmpty()) {
            return stackSecond.pop();
        }

        while (!stackFirst.isEmpty()) {
            stackSecond.push(stackFirst.pop());
        }
        return stackSecond.pop();
    }

    public int size() {
        return stackFirst.size() + stackSecond.size();
    }

}