package adts;
import nodes.LLNode;
import interfaces.QueueInterface;

public class LLQueue<E> implements QueueInterface<E> {
	private LLNode<E> head;
	private LLNode<E> tail;
	
	public void enqueue(E element) {
		LLNode<E> newNode = new LLNode<E>(element);
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			head.setNext(newNode);
			head = newNode;
		}
	}
	
	public E dequeue() {
		if (!isEmpty()) {			
			// update dequeue
			LLNode<E> temp = tail;
			tail = tail.getNext();

			if (tail == null) {
				head = null;
			}
			
			return temp.getData();
		}
		return null;
	}
	
	public boolean isEmpty() {
		if (head == null && tail == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFull() {
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder qString = new StringBuilder();
		qString.append("Queue: \n");
		LLNode<E> ptr = tail;
		while (ptr != null) {
			qString.append(ptr.getData() + "\n");
			ptr = ptr.getNext();
		}
		
		return qString.toString();
	}
	
}
