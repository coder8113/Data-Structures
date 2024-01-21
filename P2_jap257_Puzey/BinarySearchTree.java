import java.util.Arrays;

//class to represent a binary search tree and its methods
public class BinarySearchTree {

    //node class that defines BST node
    public static class Node {
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }
    // root of the tree
    Node root;

    // Constructor, creates initial empty tree
    BinarySearchTree(){
        root = null;
    }

    // recursive method to insert a node into the tree
    void insert(int key)  {
        root = insertRec(root, key);
    }

    //recursive insert function
    Node insertRec(Node root, int key) {

        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        //traverse the tree
        if (key < root.key)

            //insert in the left subtree
            root.left = insertRec(root.left, key);

        else if (key > root.key)

            //insert in the right subtree
            root.right = insertRec(root.right, key);

        // return pointer
        return root;
    }

    // recursive method for preorder traversal of BST
    public void preorderRec() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    //recursive method to determine the sum of the elements in a binary search tree
    public int sum() {
        return sum(root);
    }

    private int sum(Node root) {

        if (root == null) {
            return 0;
        }
        return root.key + sum(root.left) + sum(root.right);
    }


    // a function that will perform the in-order traversal of the bst
    static int counter = 0;
    static void inOrder(Node root, int[] a, int i) {
        // checking the base case
        if (root == null)
            return;
        if (counter > (a.length - 1)){
            counter = 0;
        }

        // traversing the left subtree
        inOrder(root.left, a, i);

        // inserting the current root's data into the array
        a[counter] = root.key;
        counter++;


        // traversing the right subtree
        inOrder(root.right, a, i);
    }

    // defining a function that will return the Kth largest element in bst.
    public int KthLargestElement(Node root, int k, int n) {

        // checking the base case
        if (root == null)
            return -1;

        // initializing an array to store the elements of the bst
        int[] a = new int[n];

        // calling the helper in-order function
        inOrder(root, a, 0);

        // defining a counter and i which will help traverse the array.
        int counter = 0;
        int i = a.length - 1;

        // decrementing the counter
        while (counter < k ) {
            i = i - 1;
            counter = counter + 1;
        }

        // returning the kth largest element of the bst
        return a[i + 1];


    }



//main method for the class

    public static void main(String[] args)  {
        //create a BST object
        BinarySearchTree bst = new BinarySearchTree();

        //insert data into BST
        int[] keys = {45, 10, 7, 12, 90, 50};
        for (int key : keys) {
           bst.insert(key);
        }
       //test of preorder traversal method
       System.out.println("Preorder Traversal:");
       bst.preorderRec();

       System.out.println("Sum of keys: " + bst.sum());


        //creation of another binary search tree to run more tests on
        BinarySearchTree bst2 = new BinarySearchTree();

        int[] keys2 = {5, 3, 8, 2, 4, 7, 9};
        for (int key : keys2) {
            bst2.insert(key);
        }

        //testing preorder traversal method
        System.out.println("Preorder Traversal:");
        bst2.preorderRec();

        //testing sum method
        System.out.println("Sum of keys: " + bst2.sum());

        //below are tests for kth biggest element method
        //test for the smallest number
        int k4 = 7;
        int n2 = 7;

        System.out.println(k4 + "th Biggest Element: " + bst2.KthLargestElement(bst2.root, k4, n2));

        //test for the largest number
        int k5 = 1;

        System.out.println(k5 + "th Biggest Element: " + bst2.KthLargestElement(bst2.root, k5, n2));

        //test for a number in the middle
        int k6 = 4;

        System.out.println(k6 + "th Biggest Element: " + bst2.KthLargestElement(bst2.root, k6, n2));
    }
}