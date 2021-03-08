public class Entry {
    private Object key;
    private Object value;
    private Entry next;

    //    private int hash;
    protected Entry() {
        this(null, null);
    }

    protected Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }


    protected Object getKey() {
        return key;
    }

    protected void setKey(Object key) {
        this.key = key;
    }

    protected Object getValue() {
        return value;
    }

    protected void setValue(Object value) {
        this.value = value;
    }

    protected Entry getNext() {
        return next;
    }

    protected void setNext(Entry next) {
        this.next = next;
    }

    protected boolean hasNext() {
        return next != null;
    }

    protected <E> boolean keyIsEqual(E key) {
        if (this.key == null && key == null) {
            return true;
        }
        if (this.key == null || key == null) {
            return false;
        }
        if (key.getClass().isInstance(this.key)) {
            E keyToCompare = (E) this.key;
            if (key.equals(keyToCompare)) {
                return true;
            }

        }
        return false;
    }
    protected static Entry[] arrayCreate(int capacity){
        Entry[] entries = new Entry[capacity];
        for (int i=0;i<capacity;i++) {
            entries[i]=new Entry();
        }
        return entries;
    }
}

