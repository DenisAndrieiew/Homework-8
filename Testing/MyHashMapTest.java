public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        int count = 1000;
        for (int i = 0; i <= count; i++) {
            String key = "Key # " + i;
            int value = i * 10;
            map.put(key, value);
        }
        String keyToChange = "Key # " + 95;
        map.remove("");
        for (int i = 0; i <= count; i++) {
            String key = "Key # " + i;
            try {
                map.getValue(key);
            } catch (IllegalKeyException e) {
                System.out.println("\n" + e.getKey() + " Key is absolutely missing! ");
            }


        }
        map.put(keyToChange, "it`s return!");
        for (int i = 0; i <= count; i++) {
            String key = "Key # " + i;
            try {
                map.getValue(key);
            } catch (IllegalKeyException e) {
                System.out.println("\n" + e.getKey() + " Key is absolutely missing! ");
            }
        }
        try {
            System.out.println(map.getValue(keyToChange));
            map.put(keyToChange, "its changed");
            System.out.println(map.getValue(keyToChange));
        } catch (IllegalKeyException e) {
            System.out.println("\n" + e.getKey() + " Key is absolutely missing! ");
        }
        map.put(keyToChange, "its changed");
        try {
            System.out.println(map.getValue(keyToChange));
        } catch (IllegalKeyException e) {
            System.out.println("\n" + e.getKey() + " Key is absolutely missing! ");
        }
//        for (int i = 0; i <= count; i++) {
//            Integer key = i;
//            try {
//                map.getValue(key);
//            } catch (IllegalKeyException e) {
//                System.out.println("\n" + e.getKey() + " Key is absolutely missing! ");
//            }
//        }

    }
}
