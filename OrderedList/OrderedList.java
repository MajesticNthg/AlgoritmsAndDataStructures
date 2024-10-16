import java.util.*;
import java.util.logging.Logger;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;
    public int size;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        size = 0;
    }
    private static final Logger logger = Logger.getLogger(OrderedList.class.getName());

    public int compare(T v1, T v2) {
        if (v1 instanceof String) {
            return compareString((String) v1, (String) v2);
        }

        if ((Integer) v1 < (Integer) v2) {
            return -1;
        }

        if (v1 == (v2)) {
            return 0;
        }

        return 1;
    }

    public void add(T value) {
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

    private int compareString(String v1, String v2) {
        String first = v1.replaceAll(" ", "");
        String second = v2.replaceAll(" ", "");

        if (first.compareTo(second) == 0) {
            return 0;
        }

        if (first.compareTo(second) < 0) {
            return -1;
        }

        return 1;
    }

    public Node<T> find(T val) {
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

    public void delete(T val) {
        if (this.head == null) {
            return;
        }

        if (this.head.value == val && count() == 1) {
            clear(true);
            return;
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

    public void deleteDuplicate() {
        if (this.count() <= 1) {
            return;
        }

        for (Node<T> node = this.head.next; node != null; node = node.next) {
            if (node.value == node.prev.value) {
                delete(node.value);
            }
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count() {
        return this.size;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    public void combination (OrderedList<T> main, OrderedList<T> excess) {
        for (Node<T> node = excess.head; node != null; node = node.next) {
            main.add(node.value);
        }
    }

    public boolean subList (OrderedList<T> sublist) {
        for (Node<T> node = sublist.head; node != null; node = node.next) {
            if (findAll(node.value) < 1) return false;
        }

        if (findAll(sublist.head.value) == 1) {
            return singleList(sublist);
        }
        return oneMoreList(sublist);
    }

    private boolean singleList (OrderedList<T> sublist) {
        ArrayList<Node<T>> arraySubList = getAll();
        int index = 0;

        for (int x = 0; x < arraySubList.size(); x++) {
            if (arraySubList.get(x).value.equals(sublist.head.value)) {
                index = x;
                break;
            }
        }

        Node<T> node = sublist.head;
        for (int x = 0; x < sublist.size; x++, index++, node = node.next) {
            if (arraySubList.get(index).value != node.value) {
                return false;
            }
        }

        return true;
    }

    private boolean oneMoreList (OrderedList<T> sublist) {
        ArrayList<Node<T>> arraySubList = getAll();
        int index = 0;
        Node<T> node = sublist.head;

        for (int x = 0; x < arraySubList.size(); x++) {
            if (arraySubList.get(x).value.equals(sublist.head.value)) {
                index = x;
                for (int i = 0; i < sublist.size; i++, index++, node = node.next) {
                    if (arraySubList.get(index).value != node.value) {
                        node = sublist.head;
                        break;
                    }
                    if (i == sublist.size - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int maxDuplicate () {
        Stack<Integer> maxInt = new Stack<>();
        Stack <Integer> maxReiteration = new Stack();

        for (Node<T> node = this.head; node != null; node = node.next) {
            int x = findAll(node.value);
            if (maxReiteration.isEmpty()) {
                maxReiteration.push((Integer)node.value);
                maxInt.push(x);
            }
            else if (maxInt.peek() < x) {
                maxReiteration.pop();
                maxReiteration.push((Integer)node.value);
                maxInt.pop();
                maxInt.push(x);
            }
        }
        if (maxInt.peek() == 1) {
            logger.info("Дубликатов нет");
        }
        return maxReiteration.peek();
    }

    private int findAll (T _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        for (Node node = this.head; node != null; node = node.next) {
            if (node.value == _value) {
                nodes.add(node);
            }
        }
        return nodes.size();
    }
}
