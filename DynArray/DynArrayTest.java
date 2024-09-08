import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DynArrayTest {
    DynArray<Integer> array;

    @BeforeEach
    void prepare() {
        array = new DynArray<>(Integer.class);

        for (int i = 0; i < 10; i++) {
            array.append(i);
        }
    }
    @Test
    void testCount() {
        DynArray<Integer> array1 = new DynArray<>(Integer.class);
        array1.append(10);
        assertEquals(1, array1.count);
    }


    @Test
    void makeArrayCapacityTest() throws Exception {
        array.makeArray(899);
        assertEquals(899, array.capacity);

        array.makeArray(-1);
        assertEquals(16, array.capacity);
    }

    @Test
    void appendTest() throws Exception {
        assertEquals(10, array.count);

        array.append(999);
        assertEquals(999, array.getItem(10));
    }

    @Test
    void getItemTest() throws Exception {
        assertEquals(0, array.getItem(0));
        assertEquals(4, array.getItem(4));
    }

    @Test
    void insertTest() throws Exception {
        assertNotEquals(777, array.getItem(0));

        array.insert(777, 0);
        assertEquals(777, array.getItem(0));

        for (int i = 1; i < 11; i++) {
            assertEquals(i - 1, array.getItem(i));
        }
    }

    @Test
    void insertOverBufferTest() throws Exception {
        for (int i = 10; i < 20; i++) {
            array.insert(i, i);
        }

        assertEquals(19, array.getItem(19));
        assertEquals(32, array.capacity);
    }

    @Test
    void insertNotEmpty () throws Exception {
        assertEquals(10, array.count);
        array.insert(99, 3);
        assertEquals(11, array.count);
    }

    @Test
    void removeTest() throws Exception {
        assertEquals(10, array.count);

        array.remove(1);

        assertEquals(2, array.getItem(1));
        assertEquals(9, array.count);
    }

    @Test
    void removeBufferCompressionTest() throws Exception {
        for (int i = 0; i < 90; i++) {
            array.append(i + 10);
        }

        for (int i = 0; i < 50; i++) {
            array.remove(i);
        }

        assertEquals(85, array.capacity);
    }
}