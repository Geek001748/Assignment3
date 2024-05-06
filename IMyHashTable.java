public interface IMyHashTable<K, V> {
    int hash (K key);
    void put (K key, V value);
    V get (K key);
    V remove (K key);
    boolean contains(V value);
    K getKey(V value);
}
