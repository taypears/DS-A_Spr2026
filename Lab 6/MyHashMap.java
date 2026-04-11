import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {
    // Define the default hash table size. Must be a power of 2
    private final static int DEFAULT_INITIAL_CAPACITY = 4;

    // Define the maximum hash table size. 1 << 30 is same as 2^30
    private final static int MAXIMUM_CAPACITY = 1 << 30;

    // Current hash table capacity. Capacity is a power of 2
    private int capacity;
    
    // Define default load factor
    private final static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    // Specify a load factor used in the hash table
    private float loadFactorThreshold;

    // The number of entries in the map
    private int size = 0;

    // Hash table is an array with each cell that is a linked list
    LinkedList<MyMap.Entry<K,V>>[] table;

        //Construct a map with the default capacity and load factor
        public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
        }

        //Construct a map with the specified initial capacity and default load factor
        public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
        }

        // Construct a map with the specified initial capacity and load factor
        public MyHashMap(int initialCapacity, float loadFactorThreshold) {
            if (initialCapacity > MAXIMUM_CAPACITY)
                this.capacity = MAXIMUM_CAPACITY;
            else
                this.capacity = trimToPowerOf2(initialCapacity);
                this.loadFactorThreshold = loadFactorThreshold;
                table = new LinkedList[capacity];
            }

        @Override // Remove all of the entries from this map

        public void clear() {
            size = 0;
            removeEntries();
        }

        @Override //Return true if the specified key is in the map
        public boolean containsKey(K key) {
            if (get(key) != null)
                return true;
            else
                return false;
        }
        
        @Override /** Return true if this map contains the value */
        public boolean containsValue(V value) {
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    LinkedList<Entry<K, V>> bucket = table[i];
                    for (Entry<K, V> entry: bucket)
                        if (entry.getValue().equals(value))
                            return true;
                }
            }

            return false;
        }

        public V get(K key) {
            int bucketIndex = hash(key.hashCode());
            if (table[bucketIndex] != null) {
                LinkedList<Entry<K, V>> bucket = table[bucketIndex];
                for (Entry<K, V> entry: bucket)
                    if (entry.getKey().equals(key))
                        return entry.getValue(); 
            }
            return null;
        }
            @Override /** Return true if this map contains no entries */
            public boolean isEmpty() {
            return size == 0;
            }

            @Override //Return a set consisting of the keys in this map
            public java.util.Set<K> keySet() {
                java.util.Set<K> set = new java.util.HashSet<>();
                    for (int i = 0; i < capacity; i++) {
                        if (table[i] != null) {
                            LinkedList<Entry<K, V>> bucket = table[i];
                            for (Entry<K, V> entry: bucket)
                                set.add(entry.getKey()); }}
            return set;}

            @Override // Add an entry (key, value) into the map

            public V put(K key, V value) {
                if (get(key) != null) { // The key is already in the map
                    int bucketIndex = hash(key.hashCode());
                    LinkedList<Entry<K, V>> bucket = table[bucketIndex];
                        for (Entry<K, V> entry: bucket)
                        if (entry.getKey().equals(key)) {
                            V oldValue = entry.getValue();

                            // Replace old value with new value
                            entry.value = value;

                            // Return the old value for the key
                            return oldValue;
                        }
                }
                // Continue with adding new entry logic...
            }

        
    }