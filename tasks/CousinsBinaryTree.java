package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import structures.*;

public class CousinsBinaryTree {
    public static boolean checkIfNotSIblings(BNode<Integer>node,int node1, int node2){
        if(node==null || node.left==null||node.right==null)return true;
        if(node.left.data.equals(node1)&&node.right.data.equals(node2)||
                node.left.data.equals(node2)&&node.right.data.equals(node1)){
            return false;//siblings
        }
        return checkIfNotSIblings(node.left,node1,node2)&&checkIfNotSIblings(
                node.right,node1,node2);
    }
    public static int getDepth(BNode<Integer> node, int depth, int value) {
        if (node == null) return -1;
        if (node.data.equals(value)) return depth;

        int leftDepth = getDepth(node.left, depth + 1, value);
        if (leftDepth != -1) return leftDepth;

        return getDepth(node.right, depth + 1, value);
    }
    public static void checkIfCousins(BinaryTree<Integer> tree,int node1,int node2){
        if(getDepth(tree.root,0,node1)==getDepth(tree.root,0,node2)
        &&checkIfNotSIblings(tree.root,node1,node2)==true){
            System.out.println("Cosuins"+getDepth( tree.root,0,node1));
        }
        else {
            System.out.println("Not cousins");
        }
    }
    public static void main(String[] args) throws IOException {
       BinaryTree<Integer>tree=new BinaryTree();
       tree.makeRoot(1);
       BNode<Integer>tmp1=tree.addChild(tree.root,2,3);
       tree.addChild(tmp1,2,5);
       tmp1=tree.addChild(tree.root,1,2);
       tree.addChild(tmp1,2,4);
       checkIfCousins(tree,2,3);
    }
}
