public class ArrayDeque<E> implements Deque<E>
{
    public static final int DEFAULT_CAPACITY = 32;

    private E[] values;

    private int size = 0;
    private int first = 0;
    private int last = -1;

    public ArrayDeque() { this(DEFAULT_CAPACITY); }

    public ArrayDeque(int capacity)
    {
         values = (E[]) new Object[capacity];
         last = capacity -1;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public E getFirst(){
         return isEmpty() ? null : values[first];
    }

    public E getLast(){
         return isEmpty() ? null : values[last];
    }

    public void addFirst(E e) throws IllegalStateException
    {
        if (size == values.length)
            throw new IllegalStateException("Deque overflow");

        first = (values.length + first-1) % values.length;
        values[first] = e;

        size++;
    }

    public void addLast(E e) throws IllegalStateException
    {
        if (size == values.length)
            throw new IllegalStateException("Deque overflow");

        last = ++last % values.length;
        values[last] = e;

        size++;
    }

    public E removeFirst()
    {
         if(isEmpty()) return null;

         E returnValue = values[first];

         values[first++] = null;
         first %= values.length;

         size--;

         if(isEmpty()) last = -1;

         return returnValue;
    }

    public E removeLast()
    {
        if(isEmpty()) return null;

        E returnValue = values[last];

        values[last] = null;
        last = (values.length + last-1) % values.length;
        size--;

        if(isEmpty()) first = 0;

        return returnValue;
    }
}
