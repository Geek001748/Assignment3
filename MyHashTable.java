public class MyHashTable<K, V> implements IMyHashTable<K, V> {

    public class HashNode<K, V> {
        private K key;
        private V value;
        HashNode<K, V> next;

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

    public int chainArraySize() {
        return chainArray.length;
    }

    public HashNode<K,V> getChainArray(int i) {
        return chainArray[i];
    }

    @Override
    public int hash(Object key) {
        return key.hashCode() % M;
    }

    @Override
    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null.");

        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainArray[index] == null) {
            chainArray[index] = newNode;
        } else {
            HashNode<K, V> current = chainArray[index];
            put(current, key, value);
        }
        size++;
    }

    private void put(HashNode<K, V> current, K key, V value) {
        if (current.key.equals(key)) {
            current.value = value;
            return;
        }
        if (current.next == null) {
            current.next = new HashNode<>(key, value);
        } else {
            put(current.next, key, value);
        }
    }

    @Override
    public V get(Object key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        return get(current, key);
    }

    private V get(HashNode<K, V> current, Object key) {
        if (current == null) {
            return null;
        }
        if (current.key.equals(key)) {
            return current.value;
        }
        return get(current.next, key);
    }

    @Override
    public V remove(Object key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        return remove(current, null, key);
    }

    private V remove(HashNode<K, V> current, HashNode<K, V> previous, Object key) {
        if (current == null) {
            return null;
        }
        if (current.key.equals(key)) {
            if (previous == null) {
                chainArray[hash(key)] = current.next;
            } else {
                previous.next = current.next;
            }
            size--;
            return current.value;
        }
        return remove(current.next, current, key);
    }

    @Override
    public boolean contains(V value) {
        for (HashNode<K, V> node : chainArray) {
            if (contains(node, value)) {
                return true;
            }
        }
        return false;
    }

    private boolean contains(HashNode<K, V> current, V value) {
        if (current == null) {
            return false;
        }
        if (current.value.equals(value)) {
            return true;
        }
        return contains(current.next, value);
    }

    @Override
    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            K key = getKey(node, value);
            if (key != null) {
                return key;
            }
        }
        return null;
    }

    private K getKey(HashNode<K, V> current, V value) {
        if (current == null) {
            return null;
        }
        if (current.value.equals(value)) {
            return current.key;
        }
        return getKey(current.next, value);
    }
}
