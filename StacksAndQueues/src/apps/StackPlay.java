package apps;

import adts.*;

public class StackPlay {

	public static void main(String[] args) {
		
		LLStack<String> myStack = new LLStack<>();
		
		System.out.println(myStack);
		System.out.println(myStack.isEmpty() ? "stack is empty" : "stack is not empty");
		System.out.println(myStack.isFull()  ? "stack is full"  : "stack is not full");
		
		myStack.push("Tomorrow");
		myStack.push("Never");
		myStack.push("Better");
		System.out.println(myStack);
		/* /
		myStack.pop( );
		myStack.pop( );
		myStack.push("Of");
		myStack.push("Luck");
		myStack.pop( );
		myStack.push("Edge");
		myStack.push("Darkness");
		myStack.push("Dies");
		myStack.pop( );
		myStack.pop( );
		myStack.push("Day");
		myStack.pop( );
		
		System.out.println(myStack);
		System.out.println(myStack.isEmpty() ? "stack is empty" : "stack is not empty");
		System.out.println(myStack.isFull()  ? "stack is full"  : "stack is not full");
		
		System.out.println("\nTest peek - should be Edge: " + myStack.peek());
		System.out.println("\nClear out the stack and explicitly test pop return value:");
		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
		System.out.println(myStack.isEmpty() ? "stack is empty" : "stack is not empty");
		System.out.println(myStack.isFull()  ? "stack is full"  : "stack is not full");
		/**/
	}

}
