import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NativeCacheTest {
    NativeCache nativeCache;
    int size;

    NativeCacheTest() {
        this.size = 19;
    }

    @BeforeEach
    void prepare() {
        nativeCache = new NativeCache<>(this.size, Integer.class);
    }

    @Test
    void isKeyTest() {
        assertFalse(nativeCache.isKey("key1"));
        nativeCache.put("key1", 1);
        assertTrue(nativeCache.isKey("key1"));
    }

    @Test
    void putTest() {
        nativeCache.put("key1", 1);
        nativeCache.put("key2", 2);
        nativeCache.put("key3", 3);

        assertTrue(nativeCache.isKey("key1"));
        assertTrue(nativeCache.isKey("key2"));
        assertTrue(nativeCache.isKey("key3"));
        assertFalse(nativeCache.isKey("key4"));
    }

    @RepeatedTest(100)
    void getTest() {
        for (int i = 0; i < size; i++) {
            nativeCache.put(String.valueOf(i), i);
        }

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            nativeCache.get(String.valueOf(rand.nextInt(size)));
        }

        for (int i = 0; i < size; i++) {
            assertEquals(i, nativeCache.get(String.valueOf(i)));
        }

        for (int i = 0; i < size; i++) {
            assertNull(nativeCache.get(String.valueOf(i + 100)));
        }

        for (int i = 0; i < size / 2; i++) {
            nativeCache.put(String.valueOf(i + 100), i + 100);

            for (int j = 0; j < 50; j++) {
                nativeCache.get(String.valueOf(i + 100));
            }
        }

        for (int i = 0; i < size / 2; i++) {
            assertEquals(i + 100, nativeCache.get(String.valueOf(i + 100)));
        }

        int min = nativeCache.hits[0];
        int minIndex = 0;

        for (int i = 1; i < nativeCache.hits.length; i++) {
            if (nativeCache.hits[i] < min) {
                min = nativeCache.hits[i];
                minIndex = i;
            }
        }

        String key = nativeCache.slots[minIndex];
        int value = (int) nativeCache.values[minIndex];

        assertEquals(value, nativeCache.get(key));
        nativeCache.hits[minIndex]--;

        nativeCache.put("test", 777);
        assertEquals(0, nativeCache.hits[minIndex]);
        assertNull(nativeCache.get(key));
    }
}