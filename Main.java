import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int randomValue = random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(randomValue);
            table.put(key,randomValue);
        }
        for (int i = 0; i < table.chainArraySize(); i++)
        {
            MyHashTable<MyTestingClass, Integer>.HashNode<MyTestingClass, Integer> curr = table.getChainArray(i);
            System.out.println("Bucket " + i + ": " + elCount(curr, 0) + " elements");
        }
    }
    public static int elCount(MyHashTable<MyTestingClass, Integer>.HashNode<MyTestingClass, Integer>curr,int count) {
        if (curr == null) {
            return count;
        }
        return elCount(curr.next, ++count);
    }
}
