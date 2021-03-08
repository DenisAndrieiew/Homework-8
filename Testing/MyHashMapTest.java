import javax.management.openmbean.InvalidKeyException;

public class MyHashMapTest {
    public static void main(String[] args) throws InvalidKeyException {
        MyHashMap map = new MyHashMap();
        for (int i = 0; i < 15000; i++) {
            String key = "" + i;
            int value = i * 10;
            map.put(key, value);
        }



        String key2 = "key is " + 11;

        int count = 0;
        for (int i = 0; i < 15000; i++) {
            String key = "" + i;
            try {
                map.getValue(key);
            } catch (IllegalKeyException e) {
//                System.out.println(e.getMessage());
                System.out.println(e.getKey());
            }


        }
    }
}
