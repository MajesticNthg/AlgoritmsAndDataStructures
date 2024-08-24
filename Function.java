public class Function {
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

