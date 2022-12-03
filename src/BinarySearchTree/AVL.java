package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    BinaryNode root;

    // Constructor
    public AVL() {
        this.root = null;
    }

    // PreOrder Traversal
    // Visit nodes in this order
    //  Root Node -> Left Subtree -> Right Subtree
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

    // InOrder traversal
    // Visit nodes in this order
    // Left Subtree -> Root Node ->  Right Subtree
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

    // PostOrder traversal
    // Visit nodes in this order
    // Left Subtree -> Right Subtree -> Root node
    public void postOrder(BinaryNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");

    }
    // Level Order Traversal
    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.println(presentNode.value + " ");
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
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

    // getHeight
    public int getHeight(BinaryNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    //Rotate Right
    private BinaryNode rotateRight(BinaryNode disbalancedNode){
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left),getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
        return newRoot;
    }

    // Rotate Left
    private BinaryNode rotateLeft(BinaryNode disbalancedNode){
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left),getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
        return newRoot;
    }

    // getBalance
    public int getBalance(BinaryNode node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // insertNode method
    // Time Complexity: O(LogN)
    // Space Complexity: O(LogN)
    private BinaryNode insertNode(BinaryNode node, int nodeValue){
        // Base condition for recursive calls
        if(node == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if(nodeValue < node.value){
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }

        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        int balance = getBalance(node);

        // Left-Left condition
        if (balance > 1 && nodeValue < node.left.value){
            return rotateRight(node);
        }
        // Left-Right condition
        if(balance > 1 && nodeValue > node.left.value){
            // Do left rotation first on the left child of node
            node.left = rotateLeft(node.left);
            // then do right rotation on the node
            return rotateRight(node);
        }
        // Right-Right condition
        if(balance < -1 && nodeValue > node.right.value){
            return rotateLeft(node);
        }
        // Right-Left condition
        if(balance < -1 && nodeValue < node.right.value){
            // Do right rotation first
            node.right = rotateRight(node.right);
            // then do left rotation
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int value){
        this.root = insertNode(root,value);
    }

    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root){
        if(root.left == null){
            return root;
        }
        return minimumNode(root.left);
    }

    // Delete node
    // Time Complexity: O(logN)
    // Space Complexity: O(logN)
    public BinaryNode deleteNode(BinaryNode node, int value){
        if(node == null){
            System.out.println("Value not found in AVL tree");
            return node;
        }
        if(value < node.value){
            node.left = deleteNode(node.left,value);
        } else if(value > node.value){
            node.right = deleteNode(node.right,value);
        }else{
            // Node has 2 children
            if(node.left != null && node.right != null){
                BinaryNode temp = node;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right,minNodeForRight.value);
            } else if(node.left != null){
                node = node.left;
            } else if(node.right != null){
                node = node.right;
            } else{
                node = null;
            }
        }
        int balance = getBalance(node);
        // Left-Left condition
        if(balance > 1 && getBalance(node.left)>=0){
            return rotateRight(node);
        }
        // Left-Right condition
        if(balance > 1 && getBalance(node.left)<0){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // Right-Right condition
        if(balance < -1 && getBalance(node.right) <= 0){
            return rotateLeft(node);
        }
        // Right-Left condition
        if (balance < -1 && getBalance(node.right)>0){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }

    public void delete(int value){
        this.root = deleteNode(root,value);
    }



}
