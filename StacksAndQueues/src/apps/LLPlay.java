package apps;
import nodes.LLNode;

public class LLPlay {

	public static void main(String[] args) {
		LLNode<Character> newNode = new LLNode<Character>(new Character('e'));
		LLNode<Character> head = newNode;
		
		newNode = new LLNode<Character>(new Character('a'));
		newNode.setNext(head);
		head = newNode;
		
		newNode = new LLNode<Character>(new Character('t'));
		newNode.setNext(head);
		head = newNode;
		
		newNode = new LLNode<Character>(new Character('a'));
		newNode.setNext(head);
		head = newNode;
		
		newNode = new LLNode<Character>(new Character('d'));
		newNode.setNext(head);
		head = newNode;
		
		LLNode<Character> ptr = head;
		
		while(ptr.getNext() != null) {
			System.out.print(ptr.getData());
			ptr = ptr.getNext();
		}
	}

}
