public class MyTestingClass {
    private int value;

    public MyTestingClass(int value)
    {
        this.value = value;
    }
    @Override
    public int hashCode()
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
