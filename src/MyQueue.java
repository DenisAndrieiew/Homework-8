public class MyQueue extends MyLinkedList {
    public Object peek() {
        return head.next.object;
    }

    public Object poll() {
        Object o = this.get(0);
        this.remove(0);
        return o;
    }

}
