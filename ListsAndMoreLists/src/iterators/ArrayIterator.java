package iterators;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
	private E[] collection;
	private int size;
	private int current;
	
	public ArrayIterator (E[] collection, int numElements) {
		this.collection = collection;
		this.size = numElements;
	};
	
	@Override
	public boolean hasNext() {
		return current < size;
	}
	
	@Override
	public E next() {
		E temp = collection[current];
		current++;
		return temp;
	}
}
