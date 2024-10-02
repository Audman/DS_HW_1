public interface Deque<E>
{
    int size();

    boolean isEmpty();

    E getFirst();
    E getLast();

    void addFirst(E e);
    E removeFirst();

    void addLast(E e);
    E removeLast();

}
