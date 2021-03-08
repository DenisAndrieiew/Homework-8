public class MyArrayListTest {


    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        System.out.println("Add test");
        for (int i = 0; i < 20; i++) {

            String o = "" + (i);
            myArrayList.add(o);
        }
        System.out.println(myArrayList.toString());

        System.out.println("get element test");
        System.out.println(myArrayList.get(10));
        System.out.println("\nremove test");
        myArrayList.remove(8);

        System.out.println(myArrayList.toString());
        myArrayList.remove(15);
        System.out.println(myArrayList.toString());

        System.out.println("Size test");
        System.out.println("actual collection size is " + myArrayList.size());
        System.out.println("get element second test");
        System.out.println(myArrayList.get(10));
    }

}
