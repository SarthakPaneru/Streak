class Node {
    Card card;
    Node next;

    public Node() {
    }
    public Node(Card card) {
        this.card = card;
        this.next = null;
    }

//    @Override
//    public String toString() {
//        return card.toString();
//    }
}

public class LinkedList {

    private Node node = new Node();
    private int size = 0;

    public Node getHead() {
        return this.node;
    }

    public void add(Card card) {
        addLast(card, getNode(size));
    }

    public void add(Card card, int index) {
        if (index<0 || index>size) {
            return;
        }
        if (index==0) {
            this.addFirst(card);
        } else {
            this.addLast(card, getNode(index));
        }
    }

    public void addFirst(Card card) {
        Node first = new Node(card);
        LinkedList list = new LinkedList();
        first.next = node.next;
        node.next = first;
        size++;
    }

    public void addLast(Card card, Node node) {
        Node last = new Node(card);
        last.next = node.next;
        node.next = last;
        size++;
    }

    public void swapCard(Card card, int position) {
        Node currentNode = node;

        

        Node temp = new Node();
        temp.card = card;

        while (position>2) {
            currentNode = currentNode.next;
            position--;
        }

        temp.next = currentNode.next;
        currentNode.next = temp;
    }

    public Node getNode(int size) {
        Node node = this.node;

        for (int i = 0; i<size && node != null; i++) {
            node = node.next;
        }

        return node;
    }

    public void setNode(Card card) {
        this.node.card = card;
    }

    public String getNodeStr(int size) {
        Node node = this.node;

        for (int i = 0; i<size && node != null; i++) {
            node = node.next;
        }

        return node.toString();
    }

    public void deleteNode(int position) {
        Node temp = getHead();

        while(position>2) {
            temp=temp.next;
            position--;
        }
        temp.next = temp.next.next;
    }

    public LinkedList showList(Node head) {
        Node temp = head;
        LinkedList list = new LinkedList();

        while (temp != null) {
            list.add(temp.card);
            temp = temp.next;
        }
        return list;
    }

    public int lengthOfNode(Node head) {
        Node temp = head;
        LinkedList list = new LinkedList();

        int len = 0;

        while (temp != null) {
            list.add(temp.card);
            temp = temp.next;
            len++;
        }
        return len;
    }

    public LinkedList copy(LinkedList list) {

        LinkedList linkedList = new LinkedList();

        if (list == null) {
            return null;
        }

        linkedList.size = list.size;

        while(list.node.next != null) {
            linkedList.node.card = list.node.card;
            linkedList.node.next = list.node.next;
            list.node.next = list.node.next.next;
        }

        return linkedList;
    }

//    public void insertionSort(LinkedList list) {
//        Node temp = new Node();
////        LinkedList temp = new LinkedList();
//
//
//
//        for (int i=1; i<list.size; i++) {
//            temp = list.node;
//
//            int j = i-1;
//
//            System.out.println(temp.card.getRankPosition(temp.card.toString()));
//
//            System.out.println(list.getNode(j).card.getRankPosition(list.getNode(j).card.toString()));
//
//            while (j>=0 && temp.card.getRankPosition(temp.card.toString())<=list.getNode(j).card.getRankPosition(list.getNode(j).card.toString())) {
//                list.addBetween(temp.card, j);
//                j = j-1;
//            }
//
//        }
//    }
}
