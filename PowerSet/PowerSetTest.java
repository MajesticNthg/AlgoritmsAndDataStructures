import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {
    PowerSet powerSet;

    @BeforeEach
    void prepare() {
        powerSet = new PowerSet();
    }

    @Test
    void putTest() {
        assertFalse(powerSet.get("1"));
        powerSet.put("1");
        powerSet.put("2");
        powerSet.put("3");
        powerSet.put("3");
        powerSet.put("3");

        assertEquals(3, powerSet.size());
        assertTrue(powerSet.get("1"));
        assertFalse(powerSet.get("0"));
    }

    @Test
    void sizeTest() {
        assertEquals(0, powerSet.size());

        for (int i = 0; i < 1000; i++) {
            String string = String.valueOf(i);
            powerSet.put(string);
        }

        assertEquals(1000, powerSet.size());
    }

    @Test
    void getTest() {
        assertFalse(powerSet.get("0"));

        for (int i = 0; i < 100; i++) {
            String string = String.valueOf(i);
            powerSet.put(string);
        }

        for (int i = 0; i < 100; i++) {
            String string = String.valueOf(i);

            assertTrue(powerSet.get(string));
        }

        assertFalse(powerSet.get("100"));
        assertEquals(100, powerSet.size());
    }

    @Test
    void removeOneTest() {
        assertEquals(0, powerSet.size());

        powerSet.put("1");
        powerSet.put("2");
        assertEquals(2, powerSet.size());

        assertTrue(powerSet.remove("1"));
        assertTrue(powerSet.remove("2"));
        assertEquals(0, powerSet.size());
    }

    // @RepeatedTest(1000)
    void removeTest() {
        assertEquals(0, powerSet.size());
        int storageSize = 10_000;
        Random rand = new Random();

        String[] strings = new String[storageSize];
        for (int i = 0; i < storageSize; i++) {
            StringBuilder builder = new StringBuilder();

            int stringLength = rand.nextInt(100) + 10;

            for (int j = 0; j < stringLength; j++) {
                int charCode = rand.nextInt(25) + 65;
                builder.append((char) charCode);
            }

            powerSet.put(builder.toString());
            strings[i] = builder.toString();
        }

        assertEquals(storageSize, powerSet.size());

        for (int i = 0; i < storageSize; i++) {
            assertTrue(powerSet.remove(strings[i]));
        }

        assertEquals(0, powerSet.size());
    }

    @Test
    void unionTest() {
        for (int i = 0; i < 50; i++) {
            powerSet.put(String.valueOf(i));
        }

        assertEquals(50, powerSet.size());

        PowerSet powerSetSec = new PowerSet();
        for (int i = 50; i < 100; i++) {
            powerSetSec.put(String.valueOf(i));
        }

        assertEquals(50, powerSetSec.size());

        PowerSet unionResult = powerSet.union(powerSetSec);

        for (int i = 0; i < 100; i++) {
            assertTrue(unionResult.get(String.valueOf(i)));
        }

        assertEquals(100, unionResult.size());
    }

    @Test
    void unionOneSetEmptyTest() {
        for (int i = 0; i < 50; i++) {
            powerSet.put(String.valueOf(i));
        }

        PowerSet powerSetSec = new PowerSet();
        PowerSet unionResult = powerSet.union(powerSetSec);

        for (int i = 0; i < 50; i++) {
            assertTrue(unionResult.get(String.valueOf(i)));
        }

        assertEquals(50, unionResult.size());
    }

    @Test
    void intersectionTest() {
        PowerSet powerSetSec = new PowerSet();

        for (int i = 0; i < 30; i++) {
            powerSet.put(String.valueOf(i));
        }

        for (int i = 20; i < 60; i++) {
            powerSetSec.put(String.valueOf(i));
        }

        PowerSet intersectionResult = powerSet.intersection(powerSetSec);

        for (int i = 20; i < 30; i++) {
            assertTrue(intersectionResult.get(String.valueOf(i)));
        }

        assertEquals(10, intersectionResult.size());
    }

    @Test
    void intersectionEmptySetTest() {
        PowerSet powerSetSec = new PowerSet();

        for (int i = 0; i < 100; i++) {
            powerSet.put(String.valueOf(i));
        }

        PowerSet intersectionResult = powerSet.intersection(powerSetSec);

        assertEquals(0, intersectionResult.size());
    }

    @Test
    void differenceTest() {
        PowerSet powerSetSec = new PowerSet();

        for (int i = 0; i < 100; i++) {
            powerSet.put(String.valueOf(i));
        }

        for (int i = 30; i < 100; i++) {
            powerSetSec.put(String.valueOf(i));
        }

        PowerSet differenceResult = powerSet.difference(powerSetSec);

        assertEquals(30, differenceResult.size());
    }

    @Test
    void differenceEmptyTest() {
        PowerSet powerSetSec = new PowerSet();

        for (int i = 0; i < 20; i++) {
            powerSet.put(String.valueOf(i));
            powerSetSec.put(String.valueOf(i));
        }

        PowerSet differenceResult = powerSet.difference(powerSetSec);
        assertEquals(0, differenceResult.size());
    }

    @Test
    void isSubsetNotAlItemsAreIncludedTest() {
        PowerSet powerSetSec = new PowerSet();

        for (int i = 0; i < 50; i++) {
            powerSet.put(String.valueOf(i));
        }

        for (int i = 30; i < 60; i++) {
            powerSetSec.put(String.valueOf(i));
        }

        assertFalse(powerSet.isSubset(powerSetSec));
    }

    @Test
    void isSubsetViceVersaTest() {
        PowerSet powerSetSec = new PowerSet();

        for (int i = 20; i < 30; i++) {
            powerSet.put(String.valueOf(i));
        }

        for (int i = 0; i < 100; i++) {
            powerSetSec.put(String.valueOf(i));
        }

        assertFalse(powerSet.isSubset(powerSetSec));
    }

    @Test
    void testMoreIntersection() {
        ArrayList <PowerSet> listPowerSet = new ArrayList<>();
        PowerSet powerSetSec = new PowerSet();

        for (int i = 0; i < 10; i++) {
            powerSetSec.put(String.valueOf(i));
        }
        listPowerSet.add(powerSetSec);

        PowerSet powerSetSecTwo = new PowerSet();

        for (int i = 2; i < 6; i++) {
            powerSetSecTwo.put(String.valueOf(i));
        }
        listPowerSet.add(powerSetSecTwo);

        PowerSet powerSetSecThird = new PowerSet();

        for (int i = 0; i < 14; i++) {
            powerSetSecThird.put(String.valueOf(i));
        }
        listPowerSet.add(powerSetSecThird);

        powerSet.moreIntersection(listPowerSet);

        assertEquals(4, powerSet.moreIntersection(listPowerSet).size());

    }
}