package tasks;
import java.util.Scanner;

import structures.*;
/*check whether a tree it is a mirror of itself (i.e., symmetric around its center). */
    
public class SymmetricTree {
    public static boolean isSymmetric(BNode<Integer>left,BNode<Integer>right){
        if(left==null && right==null) return true;
        if(left==null || right==null)return false;
        if(!left.data.equals(right.data)){
            return false;
        }
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree<Integer> tree = new BinaryTree<>();

        int rootValue = input.nextInt();
        tree.makeRoot(rootValue);
        while (input.hasNextInt()) {
            int parent = input.nextInt();
            int child = input.nextInt();
            int value = input.nextInt();

            BNode<Integer> parentNode = tree.findNode(tree.root, parent);
            if (parentNode != null) {
                tree.addChild(parentNode, child, value);
            } else {
                System.out.println("Parent node " + parent + " not found.");
                return; 
            }
        }

        if (isSymmetric(tree.root.left, tree.root.right)) {
            System.out.println("Symmetric");
        } else {
            System.out.println("Not Symmetric");
        }
    }
}
