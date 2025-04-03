package adts;

import interfaces.ListInterface;
import nodes.DLLNode;

public class DLList<E extends Comparable<E>> implements ListInterface<E> {
	protected DLLNode<E> head;
	protected DLLNode<E> tail;
	protected DLLNode<E> location;
	protected int numElements = 0;
	protected boolean found;
	
	@Override
	public void add(E element) {
		DLLNode<E> newNode = new DLLNode<E>(element);
		
		if (head == null) {
			head = tail = newNode;
		} else {
			DLLNode<E> location = head;
			while (location != null) {
				if (element.compareTo(location.getData()) > 0) {
					location = location.getNext();
				} else {
					break;
				}
			}
			
			if (location == null) {
				newNode.setPrev(tail);
				tail.setNext(newNode);
				tail = newNode;
			} else if
				 (location == head) {
					newNode.setNext(head);
					head.setPrev(newNode);
					head = newNode;
				} else {
					newNode.setPrev(location.getPrev());
					newNode.setNext(location.getNext());
					location.getPrev().setNext(newNode);
					location.setPrev(newNode);
				}
		}
		numElements++;
	}

	@Override
	public boolean remove(E element) {
		find(element);
		
		if (found) {
			if (location == head) {
				location.getNext().setPrev(null);
			} else if (location == tail) {
				location.getPrev().setNext(null);
			} else {
				location.getPrev().setNext(location.getNext());
				location.getNext().setPrev(location.getPrev());
				location.setData(null);
				location = null;
				numElements--;
			}
			return true;
		}
		
		return false;
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public boolean contains(E element) {
		DLLNode<E> ptr = head;
		while (ptr.getNext() != null) {
			if (ptr.getData().equals(element)) {
				DLLNode<E> prev = ptr.getPrev();
				DLLNode<E> next = ptr.getNext();
				prev.setNext(next);
				next.setPrev(prev);
				ptr.setData(null);
				
				return true;
			}
			ptr = ptr.getNext();
		}
		
		return false;
	}

	@Override
	public E get(E element) {
		find (element);
		
		if (found) {
			return location.getData();
		} else {
			return null;
		}
	}

	@Override
	public E get(int index) {
		location = head;
		for (int i = 0; i < index; i++) {
			location = head.getNext();
		}
		
		return location.getData();
	}
	
	private void find(E element) {
		found = false;
		location = head;
		
		while (location != null) {
			if (location.getData().equals(element)) {
				found = true;
				return;
			} else {
				location = location.getNext();
			}
		}
	}

}
