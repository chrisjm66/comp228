package adts;

import java.lang.reflect.Array;

public class ArraySortedList<E> extends ArrayBasedList<E> implements ListInterface<E> {
	public ArraySortedList() {
		super();
	}
	
	public ArraySortedList(int numElements) {
		
	}
	
	
	public void add(E element) {
		if (numElements == list.length) {
			enlarge();
		}
		
		int addLocation = 0;
		
		while ((addLocation < numElements) {
			if (((Comparable)element).compareTo(list[addLocation]) > 0) {
				
			}
		}
	}
	
	@Override
	public void find(E element) {
		found = false
		int low = 0;
		int high = list.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (element.equals(list[mid])) {
				found = true;
				location = mid;
			} else if (((Comparable)element).compareTo(list[mid]) < 0) {
				high = mid-1;
			} else if (((Comparable)element).compareTo(list[mid]) > 0) {
				low = mid+1;
			}
			
			
		}
	}
	
	@Override
	public boolean remove(E element) {
		find(element);
		if (found) {
			for(int i = location; i < numElements; i++) {
				list[i] = list[i+1];
			}
			
			list[numElements-1] = null;
			
			numElements--;
		}
	}
}
