import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T [] values;

    public NativeDictionary (int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun (String key) {
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);

        int sum = 0;
        for (byte b : bytes) {
            sum += b;
        }

        return sum % this.size;
    }

    public boolean isKey (String key) {
        return (find(key) != -1);
    }

    public void put (String key, T value) {

    }

    public T get (String key) {
        return null;
    }

    private int find(String value) {
        int index = hashFun(value);
        int i = index;

        do {
            if (this.slots[i] == null) {
                return -1;
            }

            if (this.slots[i].equals(value)) {
                return i;
            }

            i = stepIndex(i);
        } while (i != index);

        return -1;
    }

    private int stepIndex(int index) {
        index += 3;

        if (index >= this.size) {
            index -= this.size;
        }

        return index;
    }

    public int seekSlot (String value) {
        int index = hashFun(value);
        int i = index;

        do {
            if (this.slots[i] == null) {
                return i;
            }

            i = stepIndex(i);
        } while (i != index);

        return -1;
    }
}
