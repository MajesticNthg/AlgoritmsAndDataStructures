import java.util.*;

public class LinkedList {
    public Node head = null;
    public Node tail = null;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
        } else {
            this.tail.next = item;
        }
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
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

    public boolean remove(int _value) {
        if (this.head == null) {
            return false;
        }

        Node firstNode = this.head;
        Node secondNode = this.head.next;

        if (firstNode.value == _value) {
            this.head = this.head.next;
            return true;
        }


        while (secondNode != null) {
            if (secondNode.value == _value) {
                firstNode.next = secondNode.next;
                if (secondNode == this.tail) {
                    firstNode.next = null;
                    this.tail = firstNode;
                }
                return true;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        while (remove(_value));
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        int count = 0;
        Node node = this.head;

        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (this.head == null) {
            // this.head = _nodeToInsert;
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            return;
        }

        if (_nodeAfter == this.tail) {
            addInTail(_nodeToInsert);
            return;
        }

        Node node = this.head;
        while (node != _nodeAfter) {
            node = node.next;
        }

        _nodeToInsert.next = node.next;
        node.next = _nodeToInsert;

    }

    public static LinkedList twoLists(LinkedList first, LinkedList second) {
        LinkedList finalList = new LinkedList();
        if (first.count() != second.count()) {
            return finalList;
        }

        Node firstNode = first.head;
        Node secondNode = second.head;

        while (firstNode != null) {
            finalList.addInTail(new Node(firstNode.value + secondNode.value));
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return finalList;
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}

