import java.util.LinkedList;
import java.util.Stack;

public class reverseFunction {
    public void reverseQueue (Queue list1) {
        Stack<Object> myCopy = new Stack<>();

        LinkedList<Object> copy = new LinkedList<>();
        int size = list1.size();

        for (int i = 0; i < size; i++) {
            myCopy.push(list1.dequeue());
        }

        for (int i = 0; i < size; i++) {
            list1.enqueue(myCopy.pop());
        }
    }
}
