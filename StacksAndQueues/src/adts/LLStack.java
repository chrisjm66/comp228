package adts;

import interfaces.StackInterface;
import nodes.LLNode;

public class LLStack<E> implements StackInterface<E> {

	LLNode<E> top;
	
	@Override
	public void push(E element) {
		LLNode<E> newNode = new LLNode(element);
		newNode.setNext(top);
		top = newNode;
	}

	@Override
	public E pop() {
		LLNode<E> temp = top;
		top = top.getNext();
		return temp.getData();
	}

	@Override
	public E peek() {
		if (!isEmpty()) {
			return top.getData();
		} else {
			return null;
		}	
	}

	@Override
	public boolean isEmpty() {
		if(top == null) {
			return true;
		} else {
			return false;		
		}
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder qString = new StringBuilder();
		LLNode<E> ptr = top;
		qString.append("Stack:\n-------------\n");
		while (ptr != null) {
			qString.append(ptr.getData() + "\n");
			ptr = ptr.getNext();
		}
		
		return qString.toString();
	}

}
