package binarytreeLL;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    BinaryNode root;

    // Creating Binary Tree using the constructor below
    // has O(1) Time Complexity
    // Space Complexity: O(1)

    public BinaryTreeLL(){

        this.root = null; // Set root node to null
    }

    // PreOrder Traversal
    // Visit nodes in this order
    // Root node ----> Left subtree ----> Right subtree

    // Time complexity: O(N)
    // Space complexity: O(N)
    void preOrder(BinaryNode node){
        if(node == null){ // O(1)
            return;     // O(1)
        }
        // Visit Root node
        System.out.print(node.value + " "); // O(1)
        // Visit Left Subtree
        preOrder(node.left); // O(N/2)
        // Visit Right Subtree
        preOrder(node.right);// O(N/2)
    }

    // InOrder Traversal
    // Visit node in this order
    // Left Subtree ---> Root Node ----> Right Subtree
    // Time complexity: O(N)
    // Space complexity: O(N)
    void inOrder(BinaryNode node){
        if(node == null){ //O(1)
            return; // O(1)
        }

        // Visit Left Subtree
        inOrder(node.left); // O(N/2)
        // Visit Root node
        System.out.print(node.value + " "); // O(1)
        // Visit Right Subtree
        inOrder(node.right); // O(N/2)
    }

    // PostOrder Traversal
    // Visit node in this order
    // LeftSubtree ----> Right Subtree ----> Root node
    // Time complexity : O(N)
    // Space complexity: O(N)
    void postOrder(BinaryNode node){
        if(node == null){// O(1)
            return; // O(1)
        }

        // Visit Left Subtree
        postOrder(node.left); // O(N/2)
        // Visit Right Subtree
        postOrder(node.right);// O(N/2)
        // Visit root node
        System.out.print(node.value + " ");// O(1)
    }

    // Level Order Traversal
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
    }

    // Search Method
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public void search(String value){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.value == value){
                System.out.println("The value-" + value + " is found in Tree");
                return;
            }else{
                if(presentNode.left != null){
                    queue.add(presentNode.left);
                }
                if(presentNode.right != null){
                    queue.add(presentNode.right);
                }
            }
        }
        System.out.println("The value-" + value + " is not found in the Tree");
    }

    // Insert Method
    // Time complexity: O(N)
    // Space complexity: O(N)
    void insert(String value){
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if(root == null){
            root = newNode;
            System.out.println("Inserted new node at Root");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.left == null){
                presentNode.left = newNode;
                System.out.println("Successfully Inserted");
                break;
            }else if (presentNode.right == null){
                presentNode.right = newNode;
                System.out.println("Successfully Inserted");
                break;
            }
            else{
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }

    }


}
