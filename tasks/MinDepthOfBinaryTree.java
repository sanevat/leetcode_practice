package tasks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

import static java.lang.System.out;
import structures.*;



    
public class MinDepthOfBinaryTree {
    public static int minDepth(BNode<Integer>node){
        if(node==null)return 0;
        int lDepth=minDepth(node.left);
        int rDepth=minDepth(node.right);
        if(lDepth<rDepth)return 1+lDepth;
        return 1+rDepth;
    }

    public static void main(String[] args) throws IOException {
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
        out.println("Minimum depth of the tree:"+minDepth(tree.root));
    }

}
