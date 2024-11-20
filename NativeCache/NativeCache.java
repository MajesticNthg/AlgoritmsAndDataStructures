import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

public class NativeCache<T> {
    public int size;
    public String[] slots;
    public T [] values;
    public int[] hits;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        this.slots = new String[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
        this.hits = new int[size];
    }

    private int hashFun(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        int sum = 0;
        for (byte b : bytes) {
            sum += b;
        }

        return sum % this.size;
    }

    public boolean isKey(String key) {
        return find(key) > -1;
    }

    private int seekSlot(String value) {
        int index = hashFun(value);
        int i = index;

        int z = secondCheck(i, value);
        if (z == i) {
            return i;
        }
        i = stepIndex(i);

        for (int x = i; i != index; i = stepIndex(i)) {
            if (secondCheck(i, value) == i) {
                return secondCheck(i, value);
            }
        }

        return -1;
    }

    private int secondCheck (int i, String value) {
        if (this.slots[i] == null) {
            return i;
        }
        return -2;
    }
    private int stepIndex(int index) {
        index += 3;

        if (index >= this.size) {
            index -= this.size;
        }

        return index;
    }

    public int find(String value) {
        int index = hashFun(value);

        for (int i = 0; i < size; i++, index += 3) {
            if (index >= size) {
                index -= size;
            }

            if (slots[index] == null) {
                continue;
            }

            if (slots[index].equals(value)) {
                return index;
            }
        }

        return -1;
    }

    public void put(String key, T value) {
        int index = seekSlot(key);

        if (index == -1) {
            index = check();
            hits[index] = 0;
        }

        this.slots[index] = key;
        this.values[index] = value;
    }

    private int check() {
        int min = this.hits[0];
        int minIndex = 0;

        for (int i = 1; i < hits.length; i++) {
            if (this.hits[i] < min) {
                min = this.hits[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
    public T get(String key) {
        int index = find(key);

        if (index > -1) {
            this.hits[index]++;
            return this.values[index];
        }

        return null;
    }
}