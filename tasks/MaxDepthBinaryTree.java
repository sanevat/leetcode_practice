package tasks;
import static java.lang.System.*;

import java.util.Scanner;

import structures.*;

public class MaxDepthBinaryTree {

    public static int maxDepth(BNode<Integer>node){
        if(node==null)return 0;
        int lDepth=maxDepth(node.left);
        int rDepth=maxDepth(node.right);
        if(lDepth>rDepth)
            return lDepth+1;
        return rDepth+1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree<Integer> tree = new BinaryTree<>();

        int rootValue = input.nextInt();
        tree.makeRoot(rootValue);
      
        while (input.hasNext()) {
            int parent = input.nextInt();
            int where = input.nextInt(); 
            int value = input.nextInt(); 
            BNode<Integer> parentNode = tree.findNode(tree.root, parent);
            tree.addChild(parentNode, where, value);
        }
        out.println("Maximum depth of the tree:"+maxDepth(tree.root));

    }
}
