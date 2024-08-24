import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class LinkedListTest {
    @Test
    void findAll() {
        LinkedList myList = new LinkedList();
        myList.addInTail(new Node (0));
        myList.addInTail(new Node (1));
        myList.addInTail(new Node (4));
        myList.addInTail(new Node (3));
        myList.addInTail(new Node (4));
        myList.addInTail(new Node (4));
        myList.addInTail(new Node (4));

        ArrayList<Node> secondList = myList.findAll(4);
        assertEquals(4, secondList.size());
    }

    @Test
    void removeOnlyOne() {
        LinkedList myList = new LinkedList();
        myList.addInTail(new Node(4));
        myList.remove(4);

        assertEquals(null, myList.head);
    }

    @Test
    void remove() {
        LinkedList myList = new LinkedList();
        myList.addInTail(new Node(1));
        myList.addInTail(new Node(2));
        myList.addInTail(new Node(3));
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(6));

        myList.remove(6);
        assertEquals(myList.tail.value, myList.find(5).value);
        myList.remove(5);
        assertEquals(myList.tail.value, myList.find(4).value);
        myList.remove(4);

        assertEquals(3, myList.count());
    }
    @Test
    void removeSome() {
        LinkedList myList = new LinkedList();
        myList.addInTail(new Node (0));
        myList.addInTail(new Node (1));
        myList.addInTail(new Node (3));
        myList.addInTail(new Node (4));
        myList.addInTail(new Node (5));
        myList.addInTail(new Node (5));
        myList.addInTail(new Node (5));
        myList.addInTail(new Node (8));
        myList.removeAll(8);
        assertEquals(7, myList.count());
    }

    @Test
    void removeEmpty() {
        LinkedList myList = new LinkedList();
        assertFalse(myList.remove(11));
    }

    @Test
    void clear() {
        LinkedList myList = new LinkedList();
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(6));
        myList.addInTail(new Node(7));

        myList.clear();
        assertEquals(0, myList.count());
    }

    @Test
    void count() {
        LinkedList myList = new LinkedList();
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));

        assertEquals(3, myList.count());
        myList.remove(5);
        assertEquals(2, myList.count());
    }

    @Test
    void countIsEmpty() {
        LinkedList myList = new LinkedList();
        assertEquals(0, myList.count());
    }

    @Test
    void insertAfter() {
        LinkedList myList = new LinkedList();
        myList.addInTail(new Node (7));
        myList.addInTail(new Node (1));
        myList.addInTail(new Node (4));
        myList.addInTail(new Node (3));

        assertEquals(3, myList.tail.value);
        Node node = myList.find(3);
        myList.insertAfter(node, new Node(15));
        assertEquals(15, myList.tail.value);
        assertEquals(5, myList.count());
    }

    @Test
    void insertAfterInEmptyList() {
        LinkedList myList = new LinkedList();

        myList.insertAfter(new Node(3), new Node(5));
        assertEquals(0, myList.count());
    }

    @Test
    void insertAfterIsNull() {
        LinkedList myList = new LinkedList();
        myList.addInTail(new Node(5));
        myList.insertAfter(null, new Node(10));

        assertEquals(10, myList.head.value);
        assertEquals(5, myList.tail.value);
    }
    @Test
    void insertAfterSingleElements() {
        LinkedList myList = new LinkedList();
        myList.insertAfter(null, new Node(10));

        assertEquals(1, myList.count());
        assertEquals(10, myList.head.value);
        assertEquals(10, myList.tail.value);
    }

    @Test
    void twoLists() {

        LinkedList list2 = new LinkedList();
        LinkedList list = new LinkedList();
        ArrayList<Node> nodes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            nodes.add(new Node(i));
        }

        for (Node node : nodes) {
            list.addInTail(node);
            list2.addInTail(node);
        }

        LinkedList sum = LinkedList.twoLists(list, list2);

        assertEquals(0, sum.head.value);
        assertEquals(18, sum.tail.value);
    }
}

