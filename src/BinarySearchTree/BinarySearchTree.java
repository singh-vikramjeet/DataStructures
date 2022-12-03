package BinarySearchTree;

public class BinarySearchTree {
    BinaryNode root;

    // Time complexity: O(1)
    // Space complexity: O(1)
    public BinarySearchTree(){
        this.root = null;
    }

    // Insert method
    // Time complexity: O(LogN)
    // Space complexity: O(LogN)
    private BinaryNode insert(BinaryNode currentNode, int value){
        if(currentNode == null){ // O(1)
            BinaryNode newNode = new BinaryNode(); // O(1)
            newNode.value = value;// O(1)
            //System.out.println("The value successfully inserted");//O(1)
            return newNode; // O(1)
        }
        else if(value <= currentNode.value){ // O(1)
            currentNode.left = insert(currentNode.left, value); // O(N/2)
            return currentNode; // O(1)
        }
        else {
            currentNode.right = insert(currentNode.right, value); // O(N/2)
            return currentNode;// O(1)
        }
    }

    void insert(int value){
        this.root = insert(root,value);
    }


    // PreOrder traversal
    // Visit nodes in this order
    // Root node ----> Left Subtree ------> Right Subtree
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public void preOrder(BinaryNode node){
        if(node == null){
            return;
        }
        // Visit root node first
        System.out.print(node.value + " ");
        // Visit left subtree
        preOrder(node.left);
        // Visit right subtree
        preOrder(node.right);
    }

    // InOrder Traversal
    // Visit nodes in this order
    // Left Subtree ----> Root Node -----> Right Subtree
    // Time complexity: O(N)
    // Space complexity: O(N)
    public void inOrder(BinaryNode node){
        if(node == null){
            return;
        }
        // Visit Left subtree first
        inOrder(node.left);
        // Visit Root Node
        System.out.print(node.value + " ");
        // Visit Right subtree
        inOrder(node.right);
    }
    // PostOrder Traversal
    // Visit node in this order:
    // Left Subtree ---> Right Subtree ----> Root node
    // Time complexity: O(N)
    // Space complexity: O(N)
    public void postOrder(BinaryNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");

    }

    // Search Method
    // Time complexity: O(LogN)
    // Space complexity: O(LogN)
    BinaryNode search(BinaryNode node, int value){
        if(node == null){ // O(1)
            System.out.println("Value: " + value + " not found in BST");
            return null;
        } else if(node.value == value) { // O(1)
            System.out.println("Value: " + value + " found in BST");
            return node;
        } else if(value < node.value){ // O(1)
            return search(node.left,value); // O(N/2)
        } else{
            return search(node.right, value); // O(N/2)
        }
    }
    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root){
        if(root.left == null){
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node method
    // Time complexity: O(LogN)
    // Space complexity: O(LogN)
    public BinaryNode deleteNode(BinaryNode root, int value){
        if(root == null){
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value){
            root.left = deleteNode(root.left, value); // O(N/2)
        } else if(value > root.value){
            root.right = deleteNode(root.right, value); // O(N/2)
        } else{
            // Node has 2 children case
            if (root.left != null && root.right != null){
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right);// O(LogN)
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value); // O(N/2)
            }
            // Node only has left child
            else if(root.left != null){
                // Left child of the node becomes the left child of parent node
               root = root.left;
            }
            // Node only has right child
            else if(root.right != null){
                // Right child of the node becomes the right child of parent node.
                root = root.right;
            }
            else{ // Node is a leaf node
                root = null;
            }
        }
        return root;
    }
    // Delete method
    public void deleteBST(){
        this.root = null;
        System.out.println("BST has been deleted successfully!");
    }




}
