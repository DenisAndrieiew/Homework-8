class Node {
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
