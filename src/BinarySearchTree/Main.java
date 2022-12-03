package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
//        BinarySearchTree newBST = new BinarySearchTree();
//        newBST.insert(70);
//        newBST.insert(50);
//        newBST.insert(90);
//        newBST.insert(30);
//        newBST.insert(60);
//        newBST.insert(80);
//        newBST.insert(100);
//        newBST.insert(20);
//        newBST.insert(40);
//        //newBST.preOrder(newBST.root);
//        //newBST.inOrder(newBST.root);
//        //newBST.postOrder(newBST.root);
//        newBST.search(newBST.root, 90);
//        newBST.deleteNode(newBST.root,90);
//        newBST.search(newBST.root,90);
//        newBST.inOrder(newBST.root);

        // AVL tree
        AVL newAVL = new AVL();
        newAVL.insert(5);
        newAVL.insert(10);
        newAVL.insert(15);
        newAVL.insert(20);
        newAVL.levelOrder();
        newAVL.delete(5);
        System.out.println();
        newAVL.levelOrder();





    }
}
