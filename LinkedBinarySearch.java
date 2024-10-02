public class LinkedBinarySearch <E extends Comparable<E>>
{
    private static class SLNode <E extends Comparable<E>>
    {
        private E element;
        private SLNode<E> next;

        public SLNode(E e, SLNode<E> _next) {
            element = e;
            next = _next;
        }

        public E getElement() { return element; }

        public SLNode<E> getNext() { return next; }

        public void setNext(SLNode<E> _next) { next = _next; }
    }

    private static class DLNode <E extends Comparable<E>> extends SLNode<E>
    {
        private DLNode<E> prev;

        public DLNode(E e, DLNode<E> _prev, DLNode<E> _next) {
            super(e, _next);
            prev = _prev;
        }

        public DLNode<E> getPrev() { return prev; }

        public void setPrev(DLNode<E> _prev) { prev = _prev; }
    }

    public static void print(SLNode _head)
    {
        // DRY? Never heard
        SLNode current_node = _head;

        while(current_node != null)
        {
            System.out.print(current_node.getElement());

            if (current_node.getNext() != null)
                System.out.print("; ");

            current_node = current_node.getNext();
        }
    }

    public SLNode<E> constuct(E[] values, boolean _double)
    {
        if(values.length == 0) return null;

        SLNode head, tail;

        if(_double)
            head = new DLNode<>(values[0], null, null);
        else
            head = new SLNode<>(values[0], null);

        tail = head;

        for (int i = 1; i < values.length; i++)
            if(_double)
                tail.setNext(new DLNode<>(
                    values[i],
                    (DLNode<E>) tail,
                    null
                    )
                );
            else
                tail.setNext(new SLNode<>(values[i], null));


        return head;
    }

    public boolean binarySearch(SLNode _head, int size, E _target)
    {
        SLNode head, previous_head;
        previous_head = head = _head;
        while(size > 0)
        {
            for (int i = 0; i < size / 2; i++)
                head = head.getNext();

            int comparison = head.getElement().compareTo(_target);

            if (comparison > 0)
                previous_head = head;
            else if (comparison < 0)
                head = previous_head;
            else
                return true;

            size /= 2;
        }
        return false;
    }

    public boolean binarySearch(DLNode _head, int size, E _target)
    {
        return binarySearch(_head, size, _target);
    }

    /* PSEUDOCODE (but it might work)
    public boolean efficientBinarySearch(SLNode head, int size, E target)
    {
        SLNode [] array = new SLNode [size];
        for (i from 0 to size){
            array[i] = head;
            head = head.next();
        }

        do the binary search with array;
    }
    Worst case: nlogn; best case: n
    */

    public static void main(String[] args) {
        String [] arr = {
            "Hello",
            "Not hello",
            "Goodbye",
            "Not goodbye",
            "Q"
        };

        /* Nope, there are some errors */
//        SLNode start = constuct(arr,false);
//
//        print(start);
//
//        if(binarySearch(start, arr.length, "Q")) System.out.println("Yes");
    }
}
