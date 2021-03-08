import java.util.Arrays;

public class MyArrayList {
    private static final int INITIAL_CAPACITY = 10;
    private int capacity;
    Object[] items;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
    }

    public MyArrayList() {
        this(INITIAL_CAPACITY);
    }

    private static void increaseCapacity(MyArrayList myArrayList) {
        myArrayList.capacity = (int) (myArrayList.capacity * 1.25);
        myArrayList.items = Arrays.copyOf(myArrayList.items, myArrayList.capacity);
    }

    public void add(Object value) {
        int index = 0;
        while (this.items[index] != null) {
            index++;
            if (index == this.items.length - 1) {
                increaseCapacity(this);
            }
        }
        items[index] = value;

    }

    public void remove(int index) {
        Object[] buffer = Arrays.copyOf(this.items, this.items.length - 1);
        System.arraycopy(buffer, index, this.items, index - 1, this.capacity - index - 2);
        int i = 0;
        while (this.items[i] != null) {
            i++;
        }
        this.items[i - 1] = null;
    }

    // тестовый метод для отладки.
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (this.items[i] != null) {
            builder.append(this.items[i] + " ");
            i++;
        }
        return builder.toString().trim();
    }

    public int size() {
        int i = 0;
        while (this.items[i] != null) {
            i++;
        }
        return i;
    }

    public Object get(int index) {
        return this.items[index];
    }
}





