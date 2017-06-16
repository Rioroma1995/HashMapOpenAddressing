public class HashMapOpenAddressing {
    private final static int DEFAULT_CAPACITY = 16;
    private int capacity = DEFAULT_CAPACITY;
    private int size;

    private int[] keys;
    private long[] values;
    private boolean[] isUsed;

    HashMapOpenAddressing() {
        this(DEFAULT_CAPACITY);
    }

    HashMapOpenAddressing(int capacity) {
        this.capacity = capacity;
        keys = new int[capacity];
        values = new long[capacity];
        isUsed = new boolean[capacity];
    }

    private int findIndex(int key) {
        int count = 0;
        int i = hash(key);

        while (count < capacity) {
            if (key == keys[i] || !isUsed[i])
                return i;
            ++count;
            i = (++i) % capacity;
        }
        return -1;
    }


    public void put(int key, long value) {
        int index = findIndex(key);
        if (index == -1)
            throw new IllegalStateException("Sorry, HashMap is full.");

        if (!isUsed[index]) {
            isUsed[index] = true;
            ++size;
        }
        keys[index] = key;
        values[index] = value;
    }

    public long get(int key) {
        int index = findIndex(key);
        if (!contains(key))
            return Long.MIN_VALUE;
        return values[index];
    }

    public boolean contains(int key) {
        int index = findIndex(key);
        return index != -1 && isUsed[index];
    }

    public int size() {
        return size;
    }

    private int hash(int key) {
        return key % capacity;
    }

    public String toString() {
        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < capacity; ++i) {
            if (isUsed[i])
                out.append("[" + keys[i] + ',' + values[i] + "]");
            else out.append("[]");
        }
        out.append("]");
        return out.toString();
    }
}
