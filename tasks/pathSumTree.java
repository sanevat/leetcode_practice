package tasks;
import java.util.Scanner;

import structures.*;

/*
 * Givne an integer targetSum, return true if the tree has a root-to-leaf path such that adding 
 * up all the values along the path equals targetSum.
 */
public class pathSumTree {
    public static boolean pathSum(BNode<Integer>node,int targetSum,int sum){
        if(sum>targetSum)return false;
        if(node==null&& sum==targetSum)return true;
        if(node==null&& sum!=targetSum)return false;
        if(sum==targetSum)return true;

        return pathSum(node.left,targetSum,node.data+sum)||
                pathSum(node.right,targetSum,node.data+sum);
    }
    public static void main(String[] args)  {
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
        if(pathSum(tree.root,22,0)){
            System.out.println("Exists");
        }
        else{
            System.out.println("Doesnt exist ");
        }

    }
}
