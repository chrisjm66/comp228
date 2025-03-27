package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class LLList<E> implements ListInterface<E> {
	
	protected LLNode<E> head;
	protected LLNode<E> tail;
	
	protected int numElements;
	
	protected boolean found;
	protected LLNode<E> location;
	protected LLNode<E> previous;
	

	@Override
	public void add(E element) {
		LLNode<E> newNode = new LLNode<>(element);
		//if (tail == null) {
		if (head == null) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		numElements++;
	}
	
	protected void find(E target)
	// helper method
	// look for the first item on the list such that item.equals(target) is true
	// if match found set instance variables as follows:
	//    set found to true
	//    set location to the array index for item
	// if no match, set found to false
	{
	    found = false;
	    location = head;
	    previous = null;

	    while (location != null) {
	        if (location.getData().equals(target)) {
	        	found = true;
	        	return;
	        }
	        else {
	        	previous = location;
	        	location = location.getNext();
	        }
	    }
	}


	@Override
	public boolean remove(E element) {
		find(element);
		if (found) {
			if (location == head) {
				head = head.getNext();
				if (head == null) {
					tail = null;
				}
			}
			else {
				if (location == tail) {
					tail = previous;
					tail.setNext(null);
				}
				else {
					previous.setNext(location.getNext());
				}
			}
			numElements--;
		}
		return found;
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
		// or return tail == null;
		// or return numElements == 0;
	}

	@Override
	public boolean contains(E element) {
		find(element);
		return found;
	}

	@Override
	public E get(E element) {
		find(element);
		if (found) {
			return location.getData();
		}
		else {
			return null;
		}
	}

	@Override
	public E get(int index) {
		if (index < 0 || index > numElements - 1) {
			return null;
		}
		else {
			LLNode<E> ptr = head;
			for (int i = 0; i < index; i++) {
				ptr = ptr.getNext();
			}
			return ptr.getData();
		}
	}
	
    @Override
	public String toString() {
    	StringBuilder listStr = new StringBuilder();
    	LLNode<E> ptr = head;
    	while (ptr != null) {
    		listStr.append(ptr.getData() + "\n");
    		ptr = ptr.getNext();
     	}
		return listStr.toString();
	}



}
