import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);

        int sum = 0;
        for (byte b : bytes) {
            sum += b;
        }

        return sum % this.size;
    }

    public boolean isKey(String key) {
        return find(key) > -1;
    }

    private int find(String value) {
        int index = hashFun(value);
        int i = index;

        int z = check(i, value);
        if (z == -1 || z == i) {
            return z;
        }
        else {
            i = stepIndex(i);
        }

        for (int x = i; i != index; i = stepIndex(i)) {
            if (check(i, value) == -1 || check(i, value) == i) {
                return check(i, value);
            }
        }

        return -1;
    }
    private int check (int i, String value) {
        if (this.slots[i] == null) {
            return -1;
        }
        if (this.slots[i].equals(value)) {
            return i;
        }
        return -2;
    }

    public void put(String key, T value) {
        int index = seekSlot(key);

        if (index > -1) {
            this.slots[index] = key;
            this.values[index] = value;
        }
    }

    public T get(String key) {
        int index = find(key);

        if (index > -1) {
            return values[index];
        }

        return null;
    }

    private int seekSlot(String value) {
        int index = hashFun(value);
        int i = index;

        int z = secondCheck(i, value);
        if (z == i) {
            return i;
        }
        else {
            i = stepIndex(i);
        }


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
}
