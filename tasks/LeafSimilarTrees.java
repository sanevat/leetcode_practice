package tasks;
import structures.*;
public class LeafSimilarTrees {
    public static boolean areLeafSimilar(BNode<Integer> node1, BNode<Integer> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.left == null && node1.right == null && node2.left == null && node2.right == null) {
            return node1.data.equals(node2.data);
        }
        return areLeafSimilar(node1.left, node2.left) && areLeafSimilar(node1.right, node2.right);
    }
    public static void main(String[] args) {
        BinaryTree<Integer> tree=new BinaryTree();
        BinaryTree<Integer>tree1=new BinaryTree();
        tree.makeRoot(3);
        BNode<Integer> tmp2=tree.addChild(tree.root,1,5);
        tree.addChild(tmp2,1,6);
        BNode<Integer>tmp3=tree.addChild(tmp2,2,2);
        tree.addChild(tmp3,1,7);
        tree.addChild(tmp3,2,4);
        BNode<Integer> tmp1=tree.addChild(tree.root,2,1);
        tree.addChild(tmp1,1,9);
        tree.addChild(tmp1,2,8);
   
        tree1.makeRoot(3);
        tmp2=tree.addChild(tree1.root,1,5);
        tree.addChild(tmp2,1,6);
        tree.addChild(tmp2,2,7);
        tmp1=tree.addChild(tree1.root,2,1);
        tree.addChild(tmp1,1,4);
        tmp3=tree.addChild(tmp1,2,2);
        tree.addChild(tmp3,1,9);
        tree.addChild(tmp3,2,8);
        if(areLeafSimilar(tree.root, tree1.root)){
            System.out.println("Trees are similar");
        }
        else{
            System.out.println("Trees are not similar");
        }
    }
}
