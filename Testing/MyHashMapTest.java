import javax.management.openmbean.InvalidKeyException;

public class MyHashMapTest {
    public static void main(String[] args) throws InvalidKeyException {
        MyHashMap map = new MyHashMap();
        for (int i = 0; i < 15000; i++) {
            Integer key =  i;
            int value = i * 10;
            map.put(key, value);
        }
        map.put("golden Key", 123098);


        String key2 = "key is " + 11;
//            System.out.println(map.getValue("key is "+4));
//        System.out.println(map.getValue(new String("golden Key")));
//        System.out.println(map.getValue(key2));
//        System.out.println(map.getValue("key is 10"));
//        System.out.println();
//        String some = new String();
//        System.out.println(map.getValue("some"));
//        System.out.println(map.getValue(null));
//        map.put(null,"this is null object");
//        System.out.println(map.getValue(null));
//        System.out.println(map.size());
////        System.out.println("clearing hashmap");
////        map.clear();
//        System.out.println(map.getValue("key is 10"));
//        System.out.println(map.getValue(null));


//t="s";
//        System.out.println("-----------");
//        Entry e1 = new Entry(null, 123);
//        Entry e2 = new Entry("s", 123);
//        Entry e3 = new Entry(null, 123);
//        System.out.println(e1.keyIsEqual(null));
//        System.out.println(e2.keyIsEqual(null));
//        System.out.println(e1.keyIsEqual("s"));
//        System.out.println(e2.keyIsEqual("s"));
//        System.out.println(e1.keyIsEqual(t));
//        System.out.println(t.getClass());
//        System.out.println(e2.getKey().getClass());
//        System.out.println(t.equals("s"));
//
        int count = 0;
        for (int i = 0; i < 15000; i++) {
             Integer key =  i;
            try {
                map.getValue(key);
            } catch (IllegalKeyException e) {
//                System.out.println(e.getMessage());
                System.out.println(e.getKey());
            }
//            count++;
//            if (count == 15) {
//                System.out.print("\n");
//                count = 0;
//            }

        }
        try {

            System.out.println("\n" + map.getValue("golden Key"));
            System.out.println("\n" + map.getValue("key is 2"));
            System.out.println("\n" + map.getValue("key is 3"));
            System.out.println("\n" + map.getValue("key is 4"));
            System.out.println("\n" + map.getValue("key is 15"));
            System.out.println("\n" + map.getValue("key is 80"));
            System.out.println("\n" + map.getValue("key is 81"));
            System.out.println("\n" + map.getValue("key is 120"));
        } catch (IllegalKeyException e) {
            System.out.println(e.getMessage());
        }
    }


}
