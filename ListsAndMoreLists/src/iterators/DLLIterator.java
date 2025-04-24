package iterators;
import java.util.Iterator;
import nodes.DLLNode;
public class DLLIterator<E extends Comparable<E>> implements Iterator<E> {
    private DLLNode<E> head;
    private DLLNode<E> tail;
    private DLLNode<E> current;
    private boolean iterateForward;

    public DLLIterator(DLLNode<E> head, DLLNode<E> tail, boolean iterateForward)
    {
        this.head = head;
        this.tail = tail;
        this.iterateForward = iterateForward;
        if (iterateForward) {
            current = head;
        }
        else {
            current = tail;
        }
    }
    @Override
    public boolean hasNext() {
        return current != null;
    }
    @Override
    public E next() {
        E temp = current.getData();
        if (iterateForward) {
            current = current.getNext();
        }
        else {
            current = current.getPrev();
        }
        return temp;
    }
}

