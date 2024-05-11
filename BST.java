import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements IBST<K, V>, Iterable<BST.Entry<K, V>>
{

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

    public static class Entry<K, V>
    {
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

    public int size()
    {
        return size;
    }

    @Override
    public Iterator<Entry<K, V>> iterator()
    {
        return new InOrderIterator(root);
    }

    private class InOrderIterator implements Iterator<Entry<K, V>>
    {
        private Node current;
        private Stack<Node> stack;

        public InOrderIterator(Node root)
        {
            current = root;
            stack = new Stack<>();
            pushLeftNodes(current);
        }

        private void pushLeftNodes(Node node)
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext()
        {
            return !stack.isEmpty();
        }

        @Override
        public Entry<K, V> next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            Node node = stack.pop();
            pushLeftNodes(node.right);
            return new Entry<>(node.key, node.value);
        }
    }

    @Override
    public void put(K key, V val)
    {
        root = put(root, key, val);
    }

    public Node put(Node root, K key, V val)
    {
        if (root == null)
        {
            size++;
            return new Node(key, val);
        } else
        {
            int pos = key.compareTo(root.key);
            if (pos > 0)
            {
                root.right = put(root.right, key, val);
            } else if (pos < 0)
            {
                root.left = put(root.left, key, val);
            } else
            {
                root.value = val;
            }
        }
        return root;
    }


    @Override
    public V get(K key)
    {
        return get(root, key);
    }

    public V get(Node root, K key)
    {
        if (root == null)
        {
            return null;
        }
        int pos = key.compareTo(root.key);
        if (pos > 0)
        {
            return get(root.right, key);
        } else if (pos < 0)
        {
            return get(root.left, key);
        } else
        {
            return root.value;
        }
    }


    @Override
    public void delete(K key)
    {
        root = delete(root, key);
    }

    public Node delete(Node root, K key)
    {
        if (root == null)
        {
            return null;
        }
        int pos = key.compareTo(root.key);
        if (pos > 0)
        {
            root.right = delete(root.right, key);
        } else if (pos < 0)
        {
            root.left = delete(root.left, key);
        } else
        {
            // Has 1 child
            if (root.right == null)
            {
                return root.left;
            }
            if (root.left == null)
            {
                return root.right;
            }
            // Has both
            root.key = findSmallestKey(root.left);
            root.left = delete(root.left, root.key);
        }
        return root;
    }

    private K findSmallestKey(Node root)
    {
        return root.left == null ? root.key : findSmallestKey(root.right);
    }
}
