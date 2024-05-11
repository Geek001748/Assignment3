import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "One");
        tree.put(2, "Two");
        tree.put(3, "Three");

        for (BST.Entry<Integer, String> entry : tree)
        {
            System.out.println("Key is " + entry.getKey() + " and value is " + entry.getValue());
        }

        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++)
        {
            int randomValue = random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(randomValue);
            table.put(key, randomValue);
        }
        for (int i = 0; i < table.chainArraySize(); i++)
        {
            MyHashTable<MyTestingClass, Integer>.HashNode<MyTestingClass, Integer> curr = table.getChainArray(i);
            System.out.println("Bucket " + i + ": " + elCount(curr, 0) + " elements");
        }
    }

    public static int elCount(MyHashTable<MyTestingClass, Integer>.HashNode<MyTestingClass, Integer> curr, int count)
    {
        if (curr == null)
        {
            return count;
        }
        return elCount(curr.next, ++count);
    }
}
