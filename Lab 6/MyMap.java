public interface MyMap<K, V> {
    //Remove all entrie from map
    public void clear();

    //returns true if key is in map
    public boolean containsKey(K key);

    //returns true if map has certain value
    public boolean containsValue(V value);

    //returns entries on map
    public java.util.Set<Entry<K, V>> entrySet();

    //returns first value matching key
    public V get(K key);

    //returns true if map contains no entries
    public boolean isEmpty();

    //returns a set containing all keys in map
    public java.util.Set<K> keySet();

    //Add an entry (key, value) to map.
    public V put(K key, V value);

    //Remove entries for the specified key
    public void remove(K key);

    //Return number of mappings in map
    public int size();

    //Return a set containing all values in map
    public java.util.Set<V> values();

    //Define inner class for Entry
    public static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }
}