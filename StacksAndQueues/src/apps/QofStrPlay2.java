package apps;
import adts.ArrayQueueFF1;

public class QofStrPlay2 {

	public static void main(String[] args) {
		
		ArrayQueueFF1<String> myQ = new ArrayQueueFF1<String>();
		
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
