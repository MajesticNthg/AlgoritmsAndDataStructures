import java.util.LinkedList;
import java.util.Stack;

public class reverseFunction {
    public void reverseQueue () {
        Queue<T> reserve = new Queue<>();
        int size = this.list.size();

        for (int i = 0; i < size; i++) {
            reserve.enqueue(list.removeLast());
        }

        for (int i = 0; i < size; i++) {
            this.list.addLast(reserve.dequeue());
        }

    }
}
