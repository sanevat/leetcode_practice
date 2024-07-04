package tasks;
import structures.*;
/*
 *  check if a binary tree satisfies the condition where the value of each node is equal
 *  to the sum of its children's values.
 */
public class RootEqualsSumChildren {
    public static boolean isSumValid(BNode<Integer>node){
        if(node.left==null &&node.right==null)return true;

        if(node.left==null&& node.right!=null){
            if(node.data!=(node.right.data)){
                return false;
            }
            return isSumValid(node.right);
        }
        else if(node.left!=null&& node.right==null){
            if(node.data!=(node.left.data)){
                return false;
            }
            return isSumValid(node.left);
        }
        if(node.data!=(node.right.data+node.left.data)){
            return false;
        }
        return isSumValid(node.left)&&isSumValid(node.right);

    }
    public static void main(String[] args) {
        BinaryTree<Integer>tree=new BinaryTree();
        tree.makeRoot(10);
        BNode<Integer>tmp1=tree.addChild(tree.root,1,4);
        BNode<Integer>tmp2=tree.addChild(tree.root,2,6);
        tree.addChild(tmp1,1,3);
        tree.addChild(tmp1,2,1);
        tree.addChild(tmp2,2,6);
        if(isSumValid(tree.root)){
            System.out.println("Condition satisfied");
        }else{
            System.out.println("Condition not satisfied");
        }
        
    }
}
