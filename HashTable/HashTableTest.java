import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;


class HashTableTest {
    HashTable hashTable;
    int size;
    int step;

    HashTableTest() {
        this.size = 997;
        this.step = 3;
    }

    @BeforeEach
    void prepare() {
        hashTable = new HashTable(this.size, this.step);
    }

    @Test
    void hashFun() {
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            int integerString = rand.nextInt((100000) + 1);
            String string = String.valueOf(integerString);

            int index = hashTable.hashFun(string);

            assertTrue(index > -1 && index < this.size);
        }
    }

    @Test
    void seekSlot() {
        assertTrue(hashTable.seekSlot("string") > -1);

        Random rand = new Random();

        for (int i = 0; i < this.size; i++) {
            int integerString = rand.nextInt((100000) + 1);
            String string = String.valueOf(integerString);

            assertTrue(hashTable.put(string) > -1);
        }

        assertEquals(-1, hashTable.seekSlot("123"));
    }

    @Test
    void seekSlotWithCollisions() {
        for (int i = 0; i < this.size; i++) {
            assertTrue(hashTable.put("string") > -1);
        }

        assertEquals(-1, hashTable.put("123"));
    }

    @Test
    void find() {
        String stOne = "0";
        int one = hashTable.seekSlot(stOne);
        assertEquals(-1, hashTable.find(stOne));
        assertEquals(one, hashTable.put(stOne));
        assertEquals(one, hashTable.find(stOne));

        String stTwo = "1";
        int two = hashTable.seekSlot(stTwo);
        assertEquals(-1, hashTable.find(stTwo));
        assertEquals(two, hashTable.put(stTwo));
        assertEquals(two, hashTable.find(stTwo));


        for (int i = 2; i < this.size; i++) {
            hashTable.put(String.valueOf(i));
        }

        for (int i = 0; i < this.size; i++) {
            assertTrue(hashTable.find(String.valueOf(i)) > -1);
        }

        assertEquals(-1, hashTable.find(String.valueOf(this.size)));
    }

    @RepeatedTest(500)
    void findSuperTest() {
        int storageSize = this.size;
        Random rand = new Random();

        String[] strings = new String[storageSize];
        for (int i = 0; i < storageSize; i++) {
            StringBuilder builder = new StringBuilder();

            int stringLength = rand.nextInt(100) + 10;

            for (int j = 0; j < stringLength; j++) {
                int charCode = rand.nextInt(25) + 50;
                builder.append((char) charCode);
            }

            hashTable.put(builder.toString());
            strings[i] = builder.toString();
        }

        for (int i = 0; i < storageSize; i++) {
            assertTrue(hashTable.find(strings[i]) > -1);
        }

        String[] seconds = new String[storageSize];
        for (int i = 0; i < storageSize; i++) {
            StringBuilder builder = new StringBuilder();

            int stringLength = rand.nextInt(100) + 110;

            for (int j = 0; j < stringLength; j++) {
                int t = rand.nextInt(25) + 50;
                builder.append((char) t);
            }

            seconds[i] = builder.toString();
        }

        for (int i = 0; i < storageSize; i++) {
            assertFalse(hashTable.find(seconds[i]) > -1);
        }
    }
}