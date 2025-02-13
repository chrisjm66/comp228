package adts;

import interfaces.QueueInterface;

public class ArrayQueueFF1<E> implements QueueInterface<E> {
	protected E[] queue;
	protected final int FRONT = 0;
	protected int rear;
	
	public ArrayQueueFF1() {
		this(10);
	}
	
	public ArrayQueueFF1(int capacity) {
		queue = (E[]) new Object[capacity];
	}
	
	public void enqueue(E element) {
		queue[rear++] = element;
	}
	
	public E dequeue() {
		E frontElement = queue[FRONT];
		for(int i = 1; i < queue.length; i++) {
			queue[i-1] = queue[i];
		}
		queue[rear--] = null;
		return frontElement;
	}
	
	public boolean isEmpty() {
		return rear == 0;
	}
	
	public boolean isFull() {
		return rear == 9;
	}
	
	@Override
	public String toString() {
		StringBuilder qString = new StringBuilder();
		qString.append("Queue: \n");
		for (int i = FRONT; i < rear; i++) {
			qString.append(queue[i] + "\n");
		}
		
		return qString.toString();
	}
}
