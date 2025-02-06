package apps;
import adts.ArrayQofStringsFF0;

public class QofStrPlay {

	public static void main(String[] args) {
		
		ArrayQofStringsFF0 myQ = new ArrayQofStringsFF0();
		
		myQ.enqueue("Li");
		myQ.enqueue("H");
		myQ.enqueue("Be");
		myQ.enqueue("H");
		System.out.println(myQ);  // Li H Be H
		
		System.out.println(myQ.isEmpty() ? "myQ is empty" : "myQ is not empty");
		System.out.println(myQ.isFull()  ? "myQ is full"  : "myQ is not full");
		System.out.println(myQ.dequeue());  // explicitly test dequeue return value
		System.out.println(myQ);  // H Be H
		myQ.dequeue();
		myQ.dequeue();
		myQ.dequeue();
		System.out.println(myQ);
		System.out.println(myQ.isEmpty() ? "myQ is empty" : "myQ is not empty");
		System.out.println(myQ.isFull()  ? "myQ is full"  : "myQ is not full");
	}

}
