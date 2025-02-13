package adts;

import interfaces.StackInterface;

public class ArrayStack<E> implements StackInterface<E> {

	E[] stack;
	protected int top = -1;
	protected static final int DEFAULT_CAPACITY = 7;
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		stack = (E[])new Object[capacity];
	}
	
	@Override
	public void push(E element) {
		top++;
		stack[top] = element;

	}

	@Override
	public E pop() {
		return stack[top--];
	}

	@Override
	public E peek() {
		return stack[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top + 1 == stack.length;
	}
	
	@Override
	public String toString() {
		StringBuilder qString = new StringBuilder();
		qString.append("Stack:\n-------------\n");
		for (int i = 0; i <= top; i++) {
			qString.append(stack[i] + "\n");
		}
		
		return qString.toString();
	}

}
