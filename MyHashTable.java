public class MyHashTable<K, V> implements IMyHashTable {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    @Override
    public int hash(Object key) {
        return key.hashCode() % M;
    }

    @Override
    public void put(Object key, Object value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>((K) key, (V) value);
        if (chainArray[index] == null) {
            chainArray[index] = newNode;
        }else {
            HashNode<K, V> curr = chainArray[index];
            put(curr, key, value);
        }
        size++;
    }
    public void put(HashNode<K, V> curr, Object key, Object value){
        if(curr.key.equals(key)){
            curr.value = (V)value;
            return;
        }
        if(curr.next == null){
            curr.next = new HashNode<>((K) key, (V) value);
            return;
        }

        put(curr.next, key, value);
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public Object getKey(Object value) {
        return null;
    }
}
