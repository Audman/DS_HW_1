public class CircularlyLinkedList<E>
{
    private static class Node<E>
    {
        private E value;
        private Node<E> next;

        public Node(E e, Node<E> _next)
        {
            value = e;
            next = _next;
        }

        public E getElement() { return value; }

        public void setNext(Node<E> _next) { next = _next; }

        public Node<E> getNext() { return next; }
    }

    private Node<E> tail = null;

    private int size = 0;

    public int size() { return size; }

    public boolean isEmpty(){ return size == 0; }

    public E first(){
        return isEmpty() ? null : tail.getNext().getElement();
    }

    public E last(){
        return isEmpty() ? null : tail.getElement();
    }

    public void rotate(){
        if(tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e)
    {
        if(size == 0)
        {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        }
        else
        {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }

        size++;
    }

    public void addLast(E e)
    {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst()
    {
        if(isEmpty()) return null;

        Node<E> head = tail.getNext();

        if(head == tail)
            tail = null;
        else
            tail.setNext(head.getNext());

        size--;

        return head.getElement();
    }

    // O(n) - because this code will go through all the list (n-1 steps)
    public void backwardsRotate()
    {
        if(size < 2)return;

        Node<E> current_tail = tail;

        while(current_tail.getNext()!=tail)
            current_tail = current_tail.getNext();

        tail = current_tail;
    }

}
