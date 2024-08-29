import java.util.*;
import java.util.ArrayList;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail (Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        }
        else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find (int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll (int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove (int _value) {
        if (this.head == null) {
            return false;
        }

        if (this.head.value == _value && count() == 1) {
            Clear();
            return true;
        }

        if (this.head.value == _value) {
            this.head = this.head.next;
            return true;
        }

        Node node = this.head;

        while (node != null) {
            if (node.value == _value && node == this.tail) {
                node.prev.next = null;
                this.tail = node.prev;
                return true;
            }
            if (node.value == _value) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll (int _value) {
        while (remove(_value)) {
            remove(_value);
        }
    }

    public int count() {
        int size = 0;
        Node node = this.head;

        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public void Clear() {
        this.head = null;
        this.tail = null;
    }

    public void insertAfter( Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (count() == 1) {
                this.tail = _nodeToInsert;
            }
            return;
        }

        if (_nodeAfter == this.tail) {
            addInTail(_nodeToInsert);
            return;
        }

        if (find(_nodeAfter.value) == null) {
            return;
        } else {
            Node node = find(_nodeAfter.value);
            _nodeToInsert.next = node.next;
            node.next = _nodeToInsert;
        }
        return;
    }

}

class Node {
    public int value;
    public Node next;
    public Node prev;
    public Node (int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}