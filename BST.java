import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements IBST<K, V>{

    private Node root;
    private int size;
    public BST()
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

    public static class Entry<K, V> {
        private K key;
        private V value;
        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
        public K getKey()
        {
            return key;
        }
        public V getValue()
        {
           return value;
        }
    }

    public int size() {
        return size;
    }
    @Override
    public Iterator<Entry<K, V>> iterator()
    {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Entry<K, V>>
    {
        private Node curr;
        private Stack<Node> stack;
        private InOrderIterator()
        {
            curr = root;
            stack = new Stack<>();
        }
        @Override
        public boolean hasNext()
        {
            return curr != null || !stack.isEmpty();
        }

        @Override
        public Entry<K, V> next()
        {
            next(curr);
            curr = stack.pop();
            Node node = curr;
            curr = curr.right;
            return new Entry<>(node.key, node.value);
        }
        public void next(Node curr)
        {
            if (curr == null)
            {
                return;
            }
            stack.push(curr);
            next(curr.left);
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
}
