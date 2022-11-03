import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private List<Entry<K, V>>[] buckets;
    private static final float LOAD_FACTOR = 0.75f;
    private int bucketSize = 100;
    private int size;

    public MyHashMap(int bucketSize) {
        this.bucketSize = bucketSize;
        buckets = new ArrayList[this.bucketSize];
        size = 0;
    }

    public MyHashMap() {
        this(100);
    }

    public int getBucketIdx(K key) {
        return Math.abs(key.hashCode() % bucketSize);
    }

    public void put(K key, V value) {
        Entry<K, V> existingEntry = getEntry(key);
        if(existingEntry !=null) {
            existingEntry.setValue(value);
        } else {
            List<Entry<K, V>> bucket = getBucket(key);
            bucket.add(new Entry<>(key, value));
            int bucketId = getBucketIdx(key);
            buckets[bucketId] = bucket;
        }
        size++;
    }

    public V remove(K key) {
        Entry<K, V> existingEntry = getEntry(key);
        V value;
        if(existingEntry ==null) {
            value = null;
        } else {
            List<Entry<K, V>> bucket = getBucket(key);
            value = existingEntry.value;
            bucket.remove(existingEntry);
            size--;
        }
        return value;
    }

    public V get(K key) {
        V value;
        if (!containsKey(key)) {
            value = null;
        } else {
            value = getEntry(key).getValue();
        }
        return value;
    }

    public boolean containsKey(K key) {
        int bucketId = getBucketIdx(key);
        if (bucketId >= bucketSize || buckets[bucketId] == null || buckets[bucketId].isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    List<Entry<K, V>> getBucket(K key) {
        if (!containsKey(key)) {
            return new ArrayList<>();
        }
        int bucketId = getBucketIdx(key);
        return buckets[bucketId];
    }

    Entry<K, V> getEntry(K key) {
        List<Entry<K, V>> bucket = getBucket(key);
        Entry<K, V> existingEntry = null;
        if (bucket.isEmpty()) {
            existingEntry = null;
        } else {

            for (Entry<K, V> entry : bucket) {
                if (key.equals(entry.getKey())) {
                    existingEntry = entry;
                    break;
                }
            }
        }
        return existingEntry;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

class MainClass {
    public static void main(String[] args) {
         MyHashMap<String, String> myMap = new MyHashMap<>();
         myMap.put("test", "test value");
         myMap.put("test", "test value 3234");
         myMap.put("test", "test value");

         myMap.put("test2", "test value");
         myMap.put("test2", "test value 23");
         myMap.put("test2", "test value 2");

         System.out.printf("%s - %s\n", "test", myMap.get("test"));
         System.out.printf("%s - %s\n", "test2", myMap.get("test2"));

    }
}

