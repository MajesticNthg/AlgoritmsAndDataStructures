import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class LinkedList2Test {
    @Test
    void findOneElements() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(6));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));


        assertEquals(5, myList.find(5).value);
    }

    @Test
    void findElementIsMissing() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(6));

        assertNull(myList.find(15));
    }

    @Test
    void findElementsIsEmptyList() {
        LinkedList2 myList = new LinkedList2();

        assertNull(myList.find(15));
    }

    @Test
    void findElementsSizeIsOne() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));

        assertEquals(4, myList.find(4).value);
    }

    @Test
    void findAllWhenCorrectElementsIsOne() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        ArrayList<Node> myListAll = myList.findAll(5);

        assertEquals(1, myListAll.size());
        assertEquals(5, myListAll.getFirst().value);
    }

    @Test
    void findAllSomeElements() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        ArrayList<Node> myListAll = myList.findAll(5);

        assertEquals(4, myListAll.size());

        for (Node node : myListAll) {
            assertEquals(5, node.value);
        }
    }

    @Test
    void findAllWithoutCorrectElements() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        ArrayList<Node> myListAll = myList.findAll(6);

        assertEquals(0, myListAll.size());
    }

    @Test
    void removeOneElements () {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        myList.remove(5);

        assertEquals(4, myList.count());
        assertEquals(5, myList.tail.value);
        assertEquals(4, myList.head.value);
    }
    @Test
    void clear() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        assertEquals(5, myList.count());
        myList.clear();
        assertEquals(0, myList.count());
    }

    @Test
    void removeHead () {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        myList.remove(4);

        assertEquals(2, myList.count());
        assertEquals(5, myList.head.value);
        assertEquals(3, myList.tail.value);
    }

    @Test
    void removeTail () {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        myList.addInTail(new Node(3));
        myList.remove(3);
        myList.remove(3);

        assertEquals(2, myList.count());
        assertEquals(4, myList.head.value);
        assertEquals(5, myList.tail.value);
    }

    @Test
    void removeIsEmpty () {
        LinkedList2 myList = new LinkedList2();

        assertFalse(myList.remove(5));
        assertEquals(0, myList.count());

    }

    @Test
    void removeOneMoreInTail () {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        myList.remove(5);
        assertEquals(4, myList.count());
        myList.remove(5);
        assertEquals(3, myList.count());
        myList.remove(5);
        assertEquals(2, myList.count());
        assertFalse(myList.remove(5));
    }

    @Test
    void removeOneElementsRemain () {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));

        myList.remove(4);
        assertEquals(1, myList.count());

        assertEquals(myList.head.value, myList.tail.value);
        assertSame(myList.head, myList.tail);
        assertSame(myList.head, myList.find(5));
        assertSame(myList.tail, myList.find(5));

    }
    @Test
    void removeAll () {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(4));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(3));
        myList.addInTail(new Node(5));
        myList.addInTail(new Node(5));
        myList.removeAll(5);

        assertEquals(2, myList.count());
        assertEquals(3, myList.tail.value);
        assertEquals(4, myList.head.value);
    }
    @Test
    void insertAfter() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node (7));
        myList.addInTail(new Node (1));
        myList.addInTail(new Node (4));
        myList.addInTail(new Node (3));

        assertEquals(3, myList.tail.value);
        Node node = myList.find(3);
        myList.insertAfter(node, new Node(15));
        assertEquals(15, myList.tail.value);
        assertEquals(5, myList.count());
        assertEquals(3, myList.tail.prev.value);
        assertSame(myList.find(3), myList.tail.prev);
    }

    @Test
    void insertAfterInEmptyList() {
        LinkedList2 myList = new LinkedList2();

        myList.insertAfter(new Node(3), new Node(5));
        assertEquals(0, myList.count());
    }

    @Test
    void insertAfterIsNull() {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node(5));
        myList.insertAfter(null, new Node(10));

        assertEquals(10, myList.head.value);
        assertEquals(5, myList.tail.value);
    }
    @Test
    void insertAfterSingleElements() {
        LinkedList2 myList = new LinkedList2();
        myList.insertAfter(null, new Node(10));

        assertEquals(1, myList.count());
        assertEquals(10, myList.head.value);
        assertEquals(10, myList.tail.value);
    }

    @Test
    void insertAfterHead () {
        LinkedList2 myList = new LinkedList2();
        myList.addInTail(new Node (7));
        myList.addInTail(new Node (1));
        myList.addInTail(new Node (4));
        myList.addInTail(new Node (3));

        myList.insertAfter(null, new Node(16));
        assertEquals(5, myList.count());
        assertEquals(16, myList.head.value);
        assertNull(myList.head.prev);
    }
}