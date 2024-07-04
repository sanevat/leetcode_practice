package tasks;

import structures.*;

public class InvertBinaryTree {
    public static void invert(BNode<Integer> node) {
        if (node == null) return;
        BNode<Integer> temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
    }
    public static void main(String[] args) {
        BinaryTree<Integer> tree=new BinaryTree();
        tree.makeRoot(4);
        BNode<Integer> tmp1=tree.addChild(tree.root,1,2);
        BNode<Integer> tmp2=tree.addChild(tree.root,2,7);
        tree.addChild(tmp1,1,1);
        tree.addChild(tmp1,2,3);
        tree.addChild(tmp2,1,6);
        tree.addChild(tmp2,2,9);

        tree.preOrder();
        System.out.println("______________");
        invert(tree.root);
        tree.preOrder();  
          
    }
}
