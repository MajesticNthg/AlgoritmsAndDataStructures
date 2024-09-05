import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T> {
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray (Class clz) {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray (int new_capacity) {
        if (new_capacity < 16) {
            capacity = 16;
            return;
        } else {
            capacity = new_capacity;
        }

        if (count == 0) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
        } else {
            array = Arrays.copyOf(array, new_capacity);
        }
    }

    public T getItem (int index) throws Exception {
        if (index > count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Error, index is not correct");
        }
        return array[index];
    }

    public void append (T itm) {
        capacitySize();

        array[count++] = itm;
    }

    public void insert (T itm, int index) {
        capacitySize();

        if (index == count) {
            append(itm);
            return;
        }

        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = itm;
    }

    public void remove (int index) throws Exception {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException("Index is not correct");
        }

        for (int i = index; i < count; i++) {
            array[i] = array[i + 1];
        }
        array[count - 1] = null;
        count--;

        if (capacity > 16 && count < capacity / 2) {
            makeArray((int)(capacity / 1.5));
        }
        if (capacity < 16) {
            capacity = 16;
        }
    }

    private void capacitySize() {
        if (count >= capacity) {
            makeArray(capacity * 2);
        }
    }
}
