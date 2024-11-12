import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {
    NativeDictionary nativeDictionary;
    int size;

    NativeDictionaryTest() {
        this.size = 997;
    }

    @BeforeEach
    void prepare() {
        nativeDictionary = new NativeDictionary<>(this.size, Integer.class);
    }

    @Test
    void putTest() {
        nativeDictionary.put("key1", 1);
        nativeDictionary.put("key2", 2);
        nativeDictionary.put("key3", 3);

        assertTrue(nativeDictionary.isKey("key1"));
        assertTrue(nativeDictionary.isKey("key2"));
        assertTrue(nativeDictionary.isKey("key3"));
        assertFalse(nativeDictionary.isKey("key4"));
    }

    @Test
    void isKeyTest() {
        assertFalse(nativeDictionary.isKey("key1"));
        nativeDictionary.put("key1", 1);
        assertTrue(nativeDictionary.isKey("key1"));
    }

    @Test
    void getTest() {
        nativeDictionary.put("key1", 1);
        nativeDictionary.put("key2", 2);
        nativeDictionary.put("key3", 3);

        assertEquals(3, nativeDictionary.get("key3"));
        assertEquals(2, nativeDictionary.get("key2"));
        assertEquals(1, nativeDictionary.get("key1"));
        assertNull(nativeDictionary.get("key"));
    }

    @RepeatedTest(500)
    void getSuperTest() {
        int storageSize = this.size;
        Random rand = new Random();

        String[] strings = new String[storageSize];
        for (int i = 0; i < storageSize; i++) {
            StringBuilder builder = new StringBuilder();

            int stringLength = rand.nextInt(100) + 10;;

            for (int j = 0; j < stringLength; j++) {
                int t = rand.nextInt(25) + 50;
                builder.append((char) t);
            }

            nativeDictionary.put(builder.toString(), i);
            strings[i] = builder.toString();
        }

        for (int i = 0; i < storageSize; i++) {
            assertTrue(nativeDictionary.isKey(strings[i]));
        }

        String[] stringsTwo = new String[storageSize];
        for (int i = 0; i < storageSize; i++) {
            StringBuilder builder = new StringBuilder();

            int stringLength = rand.nextInt(100) + 110;;

            for (int j = 0; j < stringLength; j++) {
                int t = rand.nextInt(25) + 50;
                builder.append((char) t);
            }

            nativeDictionary.put(builder.toString(), i);
            stringsTwo[i] = builder.toString();
        }

        for (int i = 0; i < storageSize; i++) {
            assertFalse(nativeDictionary.isKey(stringsTwo[i]));
        }
    }
}