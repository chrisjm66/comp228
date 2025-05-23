package adts;

import java.util.Iterator;
import java.util.ArrayList;

import interfaces.*;
import iterators.BSTIterator;
import nodes.BSTNode;


enum TraversalType {
	PREORDER, INORDER, POSTORDER, REVORDER, RANDOM
}


public class BinarySearchTree<T extends Comparable<T>> 
             implements BSTInterface<T>, Iterable<T> {
	
	protected BSTNode<T> root;   
	protected BSTNode<T> ptr; // for use with PP5
	protected BSTNode<T> tgt; // for use with PP5

	boolean found;   // used by remove
	
	T[] rebalanceArray;  // for rebalancing the tree
	int rebalanceIndex;  //           "
	
	// for traversals
	protected TraversalType travType;
	ArrayList<T> travList;
	

	public BinarySearchTree() {
		root = null;
		travType = TraversalType.INORDER;
	}
	
	
	public void add (T element) {
		root = recAdd(element, root);
    }
	
	private BSTNode<T> recAdd(T element, BSTNode<T> tree) {
		if (tree == null) {
			tree = new BSTNode<T>(element);
		}
		else {
			if (element.compareTo(tree.getData()) <= 0) {
				tree.setLeft(recAdd(element, tree.getLeft()));  // add to left subtree
				
			}
			else {
				tree.setRight(recAdd(element, tree.getRight()));  // add to right subtree
		    }
		}
		return tree;
	}
	
	
	public boolean remove (T element) {
		root = recRemove(element, root);
		return found;
	}
	  
	private BSTNode<T> recRemove(T element, BSTNode<T> tree) {
		if (tree == null) {
			found = false;
		}
		else {
			if (element.compareTo(tree.getData()) < 0) {
				tree.setLeft(recRemove(element, tree.getLeft()));
			}
			else {
				if (element.compareTo(tree.getData()) > 0) {
					tree.setRight(recRemove(element, tree.getRight()));
				}
				else {
					tree = removeNode(tree);
					found = true;
				}
			}
		}
		return tree;
	}

	private BSTNode<T> removeNode(BSTNode<T> tree) {
		
		T payload;
			  
		if (tree.getLeft() == null) {
			return tree.getRight();
		}
		else {
			if (tree.getRight() == null) {
				return tree.getLeft();
			}
			else {
				payload = getPredecessor(tree.getLeft());
				tree.setData(payload);
				tree.setLeft(recRemove(payload, tree.getLeft()));
				return tree;
			}
		}
	}

	private T getPredecessor(BSTNode<T> tree) {
		while (tree.getRight() != null) {
			tree = tree.getRight();
		}
		return tree.getData();
	}

	  
	public int size() {
		return recSize(root);
	}
	
	private int recSize(BSTNode<T> tree) {
		if (tree == null) {
			return 0;
		}
		else {
			return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
		}
	}
	
	// this implementation of a size operation demonstrates that
	// it is possible to visit all the nodes of the tree without recursion
	public int size2() {
		int count = 0;
		if (root != null) {
			LLStack<BSTNode<T>> hold = new LLStack<BSTNode<T>>();
			BSTNode<T> currNode;
			hold.push(root);
			while (!hold.isEmpty()) {
				currNode = hold.peek();
				hold.pop();
				count++;
				if (currNode.getLeft() != null) {
					hold.push(currNode.getLeft());
				}
				if (currNode.getRight() != null) {
					hold.push(currNode.getRight());
				}
			}
		}
		return count;
	}

	  
	public boolean isEmpty() {
		return (root == null);
	}
	
	
	public boolean contains (T element) {
		return recContains(element, root);
	}
	
	private boolean recContains(T element, BSTNode<T> tree) {
		if (tree == null) {
			return false;
		}
		else {
	    	if (element.compareTo(tree.getData()) < 0) {
	    		return recContains(element, tree.getLeft());  // search left subtree
	    	}
	        else {
	        	if (element.compareTo(tree.getData()) > 0) {
	        		return recContains(element, tree.getRight());  // search right subtree
	        	}
	            else {
	                return true;  // element.compareTo(tree, the subtree's root) == 0
	            }
	        }
		}
	}

	
	public T get(T element) {
		return recGet(element, root);
	}
	
	private T recGet(T element, BSTNode<T> tree) {
		if (tree == null) {
			return null;
		}
		else {
			if (element.compareTo(tree.getData()) < 0) {
				return recGet(element, tree.getLeft());  // get from left subtree
			}
			else {
				if (element.compareTo(tree.getData()) > 0) {
					return recGet(element, tree.getRight());  // get from right subtree
				}
				else {
					return tree.getData();  // element is found!
				}
			}
		}
	}
	
	// -------- traversal related code ----------------
	
	public void setTraversalType(String order) {
		if (order.equalsIgnoreCase("pre")) {
			travType = TraversalType.PREORDER;
		}
		else {
			if (order.equalsIgnoreCase("in")) {
				travType = TraversalType.INORDER;
			}
			else {
				if (order.equalsIgnoreCase("post")) {
					travType = TraversalType.POSTORDER;
				}
				else {
					if (order.equalsIgnoreCase("random")) {
						travType = TraversalType.RANDOM;
					}
					else {
						travType = TraversalType.INORDER;
					}
				}
			}
		}
	}
	
	// iterator object instantiation for enhanced for loop:
	public Iterator<T> iterator() {
		
		travList = new ArrayList<>(size());
		
		switch (travType) {
		case INORDER:
			inOrder(root);
			break;
		case PREORDER:
			preOrder(root);
			break;
		case POSTORDER:
			postOrder(root);
			break;
		case RANDOM:
			random(root);
			break;
		}

		return new BSTIterator(travList); 
	}
	
	private void inOrder(BSTNode<T> tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			travList.add(tree.getData());
			inOrder(tree.getRight());
		}
	}
	
	private void preOrder(BSTNode<T> tree) {
		if (tree != null) {
			travList.add(tree.getData());
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}
	
	private void postOrder(BSTNode<T> tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			travList.add(tree.getData());
		}
	}

	private void random(BSTNode<T> tree) {
		if (tree != null) {
			int random = (int)(Math.random() * 2);
			if (random == 0) {
				random(tree.getLeft());
				random(tree.getRight());
				travList.add(tree.getData());
			} else {
				random(tree.getRight());
				random(tree.getLeft());
				travList.add(tree.getData());
			}
		}
	}

	// ------------------------------------------------

	
	
	public void rebalance() {
		rebalanceArray = (T[]) new Comparable[size()];
		rebalanceIndex = -1;
		fillRebalanceArray(root);
		root = null;
		recRebalance(0, rebalanceArray.length - 1);
	}
	
	private void fillRebalanceArray(BSTNode<T> tree) {
		if (tree != null) {
			fillRebalanceArray(tree.getLeft());
			rebalanceArray[++rebalanceIndex] = tree.getData();
			fillRebalanceArray(tree.getRight());
		}
	}
	
	private void recRebalance(int first, int last) {
		if (first <= last) {
			int mid = first + (last - first) / 2;
			root = recAdd(rebalanceArray[mid], root);
			recRebalance(first, mid-1);
			recRebalance(mid+1, last);
		}
	}

	public int treeHeight() {
		int height = recTreeHeight(root);
		return height == 0 ? -1 : height; // subtracting -1 since the method adds one for functionality purposes;
	}

	private int recTreeHeight(BSTNode<T> tree) {
		// check if empty
		if (tree == null) {
			return 0;
		}

		int leftHeight, rightHeight;
		leftHeight = recTreeHeight(tree.getLeft());
		rightHeight = recTreeHeight(tree.getRight());

		return Math.max(leftHeight, rightHeight) + 1; // returns whichever is maximum
	}

	public int treeHeight2() {
		// check if empty
		if (root == null) {
			return -1;
		}

		int height = 0;
		ArrayList<BSTNode<T>> list = new ArrayList<BSTNode<T>>();
		list.add(root);

		while (!list.isEmpty()) {
			height++;
			ArrayList<BSTNode<T>> newList = new ArrayList<BSTNode<T>>();

			while (!list.isEmpty()) {
				BSTNode<T> node = list.remove(0);
				if (node.getLeft() != null) {
					newList.add(node.getLeft());
				}

				if (node.getRight() != null) {
					newList.add(node.getRight());
				}
			}

			list = newList;
		}

		return height;
	}

	public boolean isPerfect() {
		return recIsPerfect(root, treeHeight());
	}

	private boolean recIsPerfect(BSTNode<T> tree, int height) {
		if (tree == null) {
			return true;
		}

		// if both nodes are null then it is a perfect tree at this current level.
		if (tree.getLeft() == null && tree.getRight() == null) {
			return height == 1; // this checks if the height is 1 (no more leafs after)
		}

		// if one or the other (we already checked both) are not null then it is not a perfect tree
		if (tree.getLeft() == null || tree.getRight() == null) {
			return false;
		}

		return recIsPerfect(tree.getLeft(), height - 1)
		&& recIsPerfect(tree.getRight(), height - 1);
	}

	@Override
	public String toString() {
		setTraversalType("pre");

		StringBuilder builder = new StringBuilder();
		builder.append("Root: " + root.getData());
		builder.append("\nLeft: " + recToString(root.getLeft()));
		builder.append("\nRight: " + recToString(root.getRight()));

		return builder.toString();
	}

	private String recToString(BSTNode<T> tree) {
		String str = "";

		if (tree == null) {
			return "";
		}

		str +=
		str += recToString(tree.getLeft()) + "/ " + tree.getData() + "\\ " + recToString(tree.getRight());
		return str;
	}
}
