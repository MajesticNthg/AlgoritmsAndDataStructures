import java.nio.charset.StandardCharsets;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    public int hashFun (String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        int sum = 0;
        for (byte b : bytes) {
            sum += b;
        }

        return sum % this.size;
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
    private int stepIndex(int index) {
        index += this.step;

        if (index >= this.size) {
            index -= this.size;
        }

        return index;
    }

    public int put (String value) {
        int index = seekSlot(value);

        if (index > -1) {
            this.slots[index] = value;
            return index;
        }

        return -1;
    }

    public int find (String value) {
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
}

