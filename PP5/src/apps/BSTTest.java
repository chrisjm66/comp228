package apps;

import adts.BinarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(1);
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(5);
        bst.add(6);
        bst.add(7);

        System.out.println("Height recursively: " + bst.treeHeight());
        System.out.println("Height iteratively: " + bst.treeHeight2());
        System.out.println("Is perfect? " + bst.isPerfect());

        System.out.println(bst);

        System.out.println("\nRebalancing...");

        bst.rebalance();

        System.out.println("Height recursively: " + bst.treeHeight());
        System.out.println("Height iteratively: " + bst.treeHeight2());
        System.out.println("Is perfect? " + bst.isPerfect());

        System.out.println(bst);

        System.out.println("Random traversal:");

        bst.setTraversalType("random");

        for (int value : bst) {
            System.out.println(value);
        }

        // NEW BST
        BinarySearchTree<String> strBst = new BinarySearchTree<String>();

        strBst.add("John");
        strBst.add("Joe");
        strBst.add("Alfred");
        strBst.add("Bob");
        strBst.add("Donald");
        strBst.add("Robert");
        strBst.add("Mike");

        System.out.println("\nSECOND BST\n--------------\n");
        System.out.println("Height recursively: " + strBst.treeHeight());
        System.out.println("Height iteratively: " + strBst.treeHeight2());
        System.out.println("Is perfect? " + strBst.isPerfect());

        System.out.println(strBst);

        System.out.println("\nRebalancing...");

        strBst.rebalance();

        System.out.println("Height recursively: " + strBst.treeHeight());
        System.out.println("Height iteratively: " + strBst.treeHeight2());
        System.out.println("Is perfect? " + strBst.isPerfect());

        System.out.println(strBst);

        System.out.println("Random traversal:");

        strBst.setTraversalType("random");

        for (String value : strBst) {
            System.out.println(value);
        }
    }
}
