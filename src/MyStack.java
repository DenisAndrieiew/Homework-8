public class MyStack extends MyLinkedList {
    Node tail = this.head;

    public void push(Object value) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        new Node(tail, value);
        this.tail = tail.next;
    }

    public Object peek() {
        return tail.object;
    }

    public Object pop() {
        Object o = this.tail.object;
        if (tail != head) {
            this.tail.previous.next = null;
            tail = tail.previous;
            return o;
        } else {
            return null;
        }
    }

    @Override
    public void add(Object value) {
        push(value);
    }

    @Override
    public void clear() {
        super.clear();
        tail = head;
    }

}
