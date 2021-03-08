public class MyLinkedList {
    Node head = new Node();

    public void add(Object value) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        new Node(tail, value);
    }

    public void remove(int index) {
        if (index <= this.size()) {
            Node tail = find(index);
            tail.previous.next = tail.next;
            tail.next.previous = tail.previous;
        }
    }

    public void clear() {
        head.next = null;
    }

    public int size() {
        int i = 0;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            i++;
        }
        return i;
    }

    private Node find(int index) {
        Node tail = head.next;
        for (int i = 0; i < index; i++) {
            tail = tail.next;
        }
        return tail;
    }

    public Object get(int index) {
        return find(index).object;
    }

    static class Node {
        protected Node previous;
        protected Node next;
        protected Object object;

        protected Node(Node previous, Object object) {

            this.object = object;
            this.previous = previous;
            if (previous != null) {
                if (previous.next != null) {
                    this.next = previous.next;
                    this.next.previous = this;
                }
                previous.next = this;
            }
        }

        protected Node() {
            this(null, null);
        }
    }
}