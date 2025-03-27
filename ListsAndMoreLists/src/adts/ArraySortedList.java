package adts;

import interfaces.ListInterface;

public class ArraySortedList<E>
   extends ArrayBasedList<E>
   implements ListInterface<E> {
	
	public ArraySortedList() {
		super();
	}
	
	public ArraySortedList(int initialCapacity) {
		super(initialCapacity);
	}
	
	@Override
	public void add(E element) {
		if (numElements == list.length) {
			enlarge();
		}
		
		int addLocation = 0;
		
		while (addLocation < numElements) {
			if (((Comparable)element).compareTo(list[addLocation]) > 0) {
				addLocation++;
			}
			else {
				break;
			}
		}
		// make room!!
		for (int i = numElements; i > addLocation; i--) {
			list[i] = list[i-1];
		}
		list[addLocation] = element;
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
	    location = 0;
	    
	    int first = 0;
	    int last  = numElements - 1;

	    while (first <= last) {
	    	int mid = (first + last) / 2;
	    	if (target.equals(list[mid])) {
	    		found = true;
	    		location = mid;
	    		return;
	    	}
	        else {
	        	if (((Comparable)target).compareTo(list[mid]) < 0) {
	        		last = mid - 1;
	        	}
	        	else {
	        		first = mid + 1;
	        	}
	        }
	    }
	}

	
	
	@Override
	public boolean remove(E element) {
		find(element);
		if (found) {
			for (int i = location; i < numElements - 1; i++) {
				list[i] = list[i+1];
			}
			list[numElements-1] = null;
			numElements--;
		}
		return found;
	}
	

}
