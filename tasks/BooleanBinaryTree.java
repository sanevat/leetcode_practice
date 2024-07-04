package tasks;
import structures.*;
/*
Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.

If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
Return the boolean result of evaluating the root node.
 */

public class BooleanBinaryTree {
    public static boolean outputOperation(BNode<Integer>node){
        if(node.left==null&& node.right==null&& node.data==1)return true;
        if(node.left==null&& node.right==null&& node.data==0)return false;
        if(node.data==2)return outputOperation(node.left)||outputOperation(node.right);
        else return outputOperation(node.left)&&outputOperation(node.right);
    }
    public static void main(String[] args) {
        BinaryTree<Integer>tree=new BinaryTree();
        tree.makeRoot(3);
        tree.addChild(tree.root,1,1);
        BNode<Integer>tmp1=tree.addChild(tree.root,2,3);
        tree.addChild(tmp1,1,1);
        tree.addChild(tmp1,2,1);
        System.out.println("Output of the boolean operation is:"+outputOperation(tree.root));
    }

}
