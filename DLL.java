public class DLL<E>
{
    private static class Node<E>
    {
        private Node<E> prev;

        //final, because we cant change it
        private Node<E> next;

        private final E value;

        public Node(E e, Node<E> _prev, Node<E> _next)
        {
            value = e;
            prev = _prev;
            next = _next;
        }

        public E getElement() {
            return value;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> _prev) {
            prev = _prev;
        }

        public void setNext(Node<E> _next) {
            next = _next;
        }

        public String toString()
        {
            return "Node: " + value.toString() + ", next: " + next.toString();
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    private int size = 0;

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public E first() {
        return isEmpty() ? null : head.getElement();
    }

    public E last(){
        return isEmpty() ? null : tail.getElement();
    }

    public void addFirst(E e)
    {
        head = new Node<>(e,null,head);

        if (size == 0) tail = head;

        size++;
    }

    public void addLast(E e)
    {
        Node<E> newest = new Node<>(e, tail, null);

        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);

        tail = newest;
        size++;
    }

    public E removeFirst()
    {
        if(size == 0)
            return null;

        E returnValue = head.getElement();

        head = head.getNext();
        head.setPrev(null); //to remove the reference from the list
        size--;

        if(size==0)
            tail = null;

        return returnValue;
    }

    public E removeLast()
    {
        if(size == 0)
            return null;

        E returnValue = tail.getElement();

        tail = tail.getPrev();
        tail.setNext(null);
        size--;

        if(size ==0)
            head = null;

        return returnValue;
    }

    public String toString()
    {
        String returnValue = "";
        Node<E> current_node = head;

        while(current_node != null)
        {
            returnValue += current_node.getElement().toString();

            if (current_node.getNext() != null)
                returnValue += "; ";

            current_node = current_node.getNext();
        }

        return returnValue;
    }

    public void append(E[] arr){
        for (E _value : arr) this.addLast(_value);
    }

}

