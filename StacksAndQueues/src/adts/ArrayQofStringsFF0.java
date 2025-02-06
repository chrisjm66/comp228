package adts;

public class ArrayQofStringsFF0 {
	protected String[] queue;
	protected final int FRONT = 0;
	protected int rear;
	
	public ArrayQofStringsFF0() {
		this(10);
	}
	
	public ArrayQofStringsFF0(int capacity) {
		queue = new String[capacity];
	}
	
	public void enqueue(String element) {
		queue[rear++] = element;
	}
	
	public String dequeue() {
		String frontElement = queue[FRONT];
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
