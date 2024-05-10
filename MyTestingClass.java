public class MyTestingClass {
    private int value;

    public MyTestingClass(int value)
    {
        this.value = value;
    }
    public int myHashCode()
    {
        return value % 11;
    }
    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
}
