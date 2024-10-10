import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node (T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;
    public int size;

    public OrderedList (boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        size = 0;
    }

    public int compare(T v1, T v2) {
        if ((Integer)v1 < (Integer)v2) {
            return -1;
        }

        if (v1 == (v2)) {
            return 0;
        }

        return 1;
    }

    public void add (T value) {
        Node<T> firstNode = new Node<>(value);
        size++;

        if (this.head == null) {
            this.head = firstNode;
            this.tail = firstNode;
            return;
        }

        Node<T> node = this.head;
        int compareVal = compare(this.head.value, firstNode.value);

        if ((this._ascending && compareVal >= 0) || (!this._ascending && compareVal <= 0)) {
            firstNode.next = this.head;
            this.head.prev = firstNode;
            this.head = firstNode;
            return;
        }

        while (node != null) {
            compareVal = compare(node.value, firstNode.value);

            if ((this._ascending && compareVal < 0) || (!this._ascending && compareVal > 0)) {
                node = node.next;
                continue;
            }

            firstNode.next = node;
            firstNode.prev = node.prev;
            node.prev.next = firstNode;
            node.prev = firstNode;
            return;
        }

        this.tail.next = firstNode;
        firstNode.prev = this.tail;
        this.tail = firstNode;

    }

    public Node<T> find (T val) {
        Node<T> node = this.head;

        while (node != null) {
            int compareVal = compare(node.value, val);

            if ((this._ascending && compareVal > 0) || !this._ascending && compareVal < 0) {
                break;
            }

            if (compareVal == 0) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void delete (T val) {
        if (this.head == null) {
            return;
        }

        if (this.head.value == val && count() == 1) {
            clear(true);
        }

        if (this.head.value == val) {
            this.head.next.prev = null;
            this.head = this.head.next;
            size--;
            return;
        }

        Node<T> node = find(val);

        if (node == null) {
            return;
        }

        if (node == this.tail) {
            node.prev.next = null;
            this.tail = node.prev;
            size--;
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void clear (boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count() {
        return this.size;
    }

    ArrayList<Node<T>> getAll () {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}