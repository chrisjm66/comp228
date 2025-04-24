// Chris Mangan. COMP228

package adts;

import interfaces.ListInterface;
import iterators.DLLIterator;
import nodes.DLLNode;

public class DLList<E extends Comparable<E>> implements Iterable<E>, ListInterface<E> {
	protected DLLNode<E> head;
	protected DLLNode<E> tail;
	protected DLLNode<E> location;
	protected int numElements = 0;
	protected boolean found;
	protected boolean iterateForward;
	
	@Override
	public void add(E element) {
		DLLNode<E> newNode = new DLLNode<E>(element);

		if (head == null) {
			head = tail = newNode;
		} else {
			DLLNode<E> ptr = head;

			while (ptr != null) {
				if (((Comparable)element).compareTo(ptr.getData()) > 0) {
					ptr = ptr.getNext();
				}
				else {
					break;
				}
			}
			
			if (ptr == null) {
				newNode.setPrev(tail);
				tail.setNext(newNode);
				tail = newNode;
			} else if (ptr == head) {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			} else {
				newNode.setPrev(ptr.getPrev());
				newNode.setNext(ptr);
				ptr.getPrev().setNext(newNode);
				ptr.setPrev(newNode);
			}
		}
		numElements++;
	}

	@Override
	public boolean remove(E element) {
		find(element);
		
		if (found) {
			if (numElements == 1) {
				head = tail = null;
			}
			else if (location == head) {
				location.getNext().setPrev(null);
				head = location.getNext();
			} else if (location == tail) {
				location.getPrev().setNext(null);
				tail = location.getPrev();
			} else {
				location.getPrev().setNext(location.getNext());
				location.getNext().setPrev(location.getPrev());

				location.setData(null);
				location = null;
			}
			numElements--;
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
		find(element);

		return found;
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
			location = location.getNext();
		}
		
		return location.getData();
	}

	public DLLIterator<E> iterator() {
		return new DLLIterator<E>(head, tail, iterateForward);
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

	public String toString() {
		DLLNode<E> ptr = head;
		StringBuilder result = new StringBuilder();

		while (ptr != null) {
			result.append(ptr.getData());
			result.append("\n");

			ptr = ptr.getNext();
		}

		return result.toString();
	}

	public void setIterateForward(boolean iterateForward) {
		this.iterateForward = iterateForward;
	}
}
