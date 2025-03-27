package iterators;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
	
	private E[] collection;
	private int size;
	private int current;
	
	public ArrayIterator(E[] collection, int size) {
		this.collection = collection;
		this.size = size;
		
		this.current = 0;
	}

	@Override
	public boolean hasNext() {
		if (current < size) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public E next() {
		E temp = collection[current];
		current++;
		return temp;
	}

}
