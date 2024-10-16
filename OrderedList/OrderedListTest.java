import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedListTest {
    @Test
    public void delete() {
        OrderedList ascending = new OrderedList(true);

        ascending.add(3);
        ascending.add(4);
        ascending.add(5);
        ascending.add(6);
        ascending.add(7);

        ascending.delete(4);
        assertEquals(4, ascending.size);
        ascending.delete(3);
        ascending.delete(5);
        ascending.delete(6);
        assertEquals(1, ascending.size);
        ascending.delete(7);
        assertEquals(0, ascending.size);

    }
    
    @Test
    public void deleteDuplicateMyList() {
        OrderedList ascending = new OrderedList(true);
        ascending.add(3);
        ascending.add(4);
        ascending.add(7);
        ascending.add(4);
        ascending.add(4);
        ascending.add(7);
        ascending.add(4);
        ascending.add(4);
        ascending.add(7);
        ascending.add(7);
        ascending.deleteDuplicate();
        assertEquals(3, ascending.size);

    }

    @Test
    public void maxDuplicateInt() {
        OrderedList ascending = new OrderedList(true);
        ascending.add(3);
        ascending.add(4);
        ascending.add(7);
        ascending.add(7);
        ascending.maxDuplicate();

        assertEquals(7, ascending.maxDuplicate());
    }

    @Test
    public void combinationTest() {
        OrderedList ascending = new OrderedList(true);
        ascending.add(3);
        ascending.add(4);
        ascending.add(7);
        ascending.add(7);

        OrderedList ascending2 = new OrderedList(true);
        ascending2.add(1);
        ascending2.add(2);

        ascending.combination(ascending, ascending2);
        assertEquals(6, ascending.size);
    }

    @Test
    public void subListTest() {
        OrderedList ascending = new OrderedList(true);
        ascending.add(3);
        ascending.add(4);
        ascending.add(7);
        ascending.add(7);

        OrderedList ascending2 = new OrderedList(true);
        ascending2.add(4);
        ascending2.add(7);

        assertTrue(ascending.subList(ascending2));
    }

    @Test
    public void oneMoreTest() {
        OrderedList ascending = new OrderedList(true);
        ascending.add(3);
        ascending.add(4);
        ascending.add(7);
        ascending.add(3);
        ascending.add(5);
        ascending.add(5);
        ascending.add(1);
        ascending.add(3);

        OrderedList ascending2 = new OrderedList(true);
        ascending2.add(1);
        ascending2.add(3);
        ascending2.add(3);

        assertTrue(ascending.subList(ascending2));
    }
}
