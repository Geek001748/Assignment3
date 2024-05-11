import java.util.Iterator;

public interface IBST<K,V>
{
    void put (K key, V val);
    V get(K key);
    void delete(K key);
    Iterator<BST.Entry<K, V>> iterator();
}
