public class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println("Testing add");
        for (int i = 0; i < 20; i++) {
            String o = "" + i;
            myStack.add(o);
        }
        for (int i = 0; i < myStack.size(); i++) {
            System.out.print(myStack.get(i) + " ");
        }
        System.out.println("\nsize is " + myStack.size());

        System.out.println("Testing remove");
        myStack.remove(12);
        myStack.remove(17);
        for (int i = 0; i < myStack.size(); i++) {
            System.out.print(myStack.get(i) + " ");
        }
        System.out.println("\nsize is " + myStack.size());

        System.out.println("size is " + myStack.size());
        System.out.println("\npeek test");
        for (int i = 0; i < 3; i++) {
            System.out.print(myStack.peek() + " ");
        }
        System.out.println("\npop test");
        for (int i = 0; i < 3; i++) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println();
        for (int i = 0; i < myStack.size(); i++) {
            System.out.print(myStack.get(i) + " ");
        }
        System.out.println("\nTesting clear");
        myStack.clear();
        for (int i = 0; i < myStack.size(); i++) {
            System.out.print(myStack.get(i) + " ");
        }
        System.out.println("\nTesting pop for void stack");
        System.out.println(myStack.pop());
    }
}
