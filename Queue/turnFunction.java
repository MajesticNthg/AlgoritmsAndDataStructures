public class turnFunction {
    public static void turn (int N, Queue list) {
        for (int i = 0; i < N; i++) {
            list.enqueue(list.dequeue());
        }
    }
}
