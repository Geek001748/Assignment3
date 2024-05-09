
public class BST<K extends Comparable<K>, V> implements IBST<K, V>{

    private Node root;
    private int size;
    public int BST()
    {
        this.root = null;
        this.size = 0;
    }
    private class Node
    {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    @Override
    public void put(K key, V val) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public Iterable<K> iterator() {
        return null;
    }
}
