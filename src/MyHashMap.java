public class MyHashMap {
    static final int INITIAL_CAPACITY = 1 << 4;
    static final int MAX_CAPACITY = 1 << 30;
    static final float LOAD_FACTOR = 0.75f;
    static final float REBUILD_FACTOR = 1.5f;
    int capacity;
    int bucketRange;
    int size = 0;
    Entry[] map;

    public MyHashMap() {
        this(INITIAL_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        map = Entry.arrayCreate(capacity);
        bucketRange = Integer.MAX_VALUE / capacity;
    }

    public void put(Object key, Object value) {
        if (key != null) {
            int hash = Math.abs(key.toString().hashCode());

            size++;

            if (size > capacity * LOAD_FACTOR && capacity < MAX_CAPACITY) {
                rebuild();
            }
            int position = (hash / bucketRange);
            Entry entry = map[position];

            if (position != 0 && entry.getKey() == null) {
                entry.setKey(key);
                entry.setValue(value);
                return;
            }
            while (entry.hasNext()) {
                if (entry.keyIsEqual(key)) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.getNext();
            }
            entry.setNext(new Entry(key, value));
        } else {
            map[0].setValue(value);
        }
    }

    public void remove(Object key) {
        if (key != null) {
            int hash = Math.abs(key.toString().hashCode());
            int position = hash / bucketRange;
            Entry entry = map[position];
            if (entry.keyIsEqual(key)) {
                map[position] = entry.getNext();
                return;
            }
            while (entry.hasNext()) {
                if (entry.getNext().keyIsEqual(key)) {
                    entry.setNext(entry.getNext().getNext());
                    size--;
                    return;
                }
                entry = entry.getNext();
            }
            System.out.println("invalid key");
            return;
        }
        map[0].setValue(null);
    }

    public void clear() {
        capacity = INITIAL_CAPACITY;
        map = Entry.arrayCreate(capacity);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object getValue(Object key) throws IllegalKeyException {
        if (key == null) {
            return map[0].getValue();
        }
        int hash = Math.abs(key.toString().hashCode());
        int position = hash / bucketRange;
        Entry entry = map[position];
        if (entry.keyIsEqual(key)) {
            return entry.getValue();
        }
        while (entry.hasNext()) {
            entry = entry.getNext();
            if (entry.keyIsEqual(key)) {
                return entry.getValue();
            }


        }
        throw new IllegalKeyException("key is absent", key);

    }

    private void rebuild() {
        int newCapacity = (int) ((capacity * REBUILD_FACTOR <= MAX_CAPACITY) ?
                (capacity * REBUILD_FACTOR) : MAX_CAPACITY);
        MyHashMap newMap = new MyHashMap(newCapacity);
        for (int i = 0; i < capacity; i++) {
            Entry entry = map[i];
            newMap.put(entry.getKey(), entry.getValue());
            while (entry.hasNext()) {
                entry = entry.getNext();
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.capacity = newCapacity;
        this.bucketRange = Integer.MAX_VALUE / capacity;
        this.size = newMap.size;
        this.map = newMap.map;
    }


    private static class Entry {
        private Object key;
        private Object value;
        private Entry next;

        private Entry() {
            this(null, null);
        }

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        private static Entry[] arrayCreate(int capacity) {
            Entry[] entries = new Entry[capacity];
            for (int i = 0; i < capacity; i++) {
                entries[i] = new Entry();
            }
            return entries;
        }

        private Object getKey() {
            return key;
        }

        private void setKey(Object key) {
            this.key = key;
        }

        private Object getValue() {
            return value;
        }

        private void setValue(Object value) {
            this.value = value;
        }

        private Entry getNext() {
            return next;
        }

        private void setNext(Entry next) {
            this.next = next;
        }

        private boolean hasNext() {
            return next != null;
        }

        private <E> boolean keyIsEqual(E key) {
            if (this.key == null && key == null) {
                return true;
            }
            if (this.key == null || key == null) {
                return false;
            }
            if (key.getClass().isInstance(this.key)) {
                E keyToCompare = (E) this.key;
                return key.equals(keyToCompare);

            }
            return false;
        }

        @Override
        public String toString() {
            if (key != null && value != null) {
                return key.toString() + " - " + value.toString();
            } else if (key != null) {
                return key.toString() + " - null";
            } else {
                return null;
            }
        }
    }
}

class IllegalKeyException extends Exception {
    private final Object key;

    public IllegalKeyException(String message, Object key) {
        super(message);
        this.key = key;

    }

    public Object getKey() {
        return key;
    }
}