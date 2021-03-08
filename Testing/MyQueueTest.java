public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println("Testing add");
        for (int i = 0; i < 20; i++) {
            String o = "" + i;
            myQueue.add(o);
        }
        for (int i = 0; i < myQueue.size(); i++) {
            System.out.print(myQueue.get(i) + " ");
        }
        System.out.println("\nsize is " + myQueue.size());

        System.out.println("Testing remove");
        myQueue.remove(12);
        myQueue.remove(17);
        for (int i = 0; i < myQueue.size(); i++) {
            System.out.print(myQueue.get(i) + " ");
        }
        System.out.println("\nsize is " + myQueue.size());

        System.out.println("size is " + myQueue.size());
        System.out.println("\npeek test");
        for (int i = 0; i < 3; i++) {
            System.out.print(myQueue.peek() + " ");
        }
        System.out.println("\npoll test");
        for (int i = 0; i < 3; i++) {
            System.out.print(myQueue.poll() + " ");
        }
        System.out.println();
        for (int i = 0; i < myQueue.size(); i++) {
            System.out.print(myQueue.get(i) + " ");
        }
        System.out.println("\nTesting clear");
        myQueue.clear();
        for (int i = 0; i < myQueue.size(); i++) {
            System.out.print(myQueue.get(i) + " ");
        }

    }

}
