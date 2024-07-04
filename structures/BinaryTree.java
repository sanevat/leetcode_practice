package structures;

public class BinaryTree<T extends Comparable<T>>{
    public BNode<T> root;

    public BinaryTree() {
        root=null;
    }

    public BinaryTree(BNode<T> root) {
        this.root = root;
    }

    public void makeRoot(T data){
        root=new BNode<>(data);
    }
    public BNode<T>getRoot(){
        return root;
    }
    public BNode<T>addChild(BNode<T>node, int where,T elem){
        BNode<T>tmp=new BNode<>(elem);
        if(where==BNode.LEFT){
            if(node.left!=null)
                return null;
            node.left=tmp;
        }
        else{
            if(node.right!=null)
                return null;
            node.right=tmp;
        }
        return tmp;
    }
    public static BNode<Integer> findNode(BNode<Integer> node, int value) {
        if (node == null) {
            return null;
        }
        if (node.data == value) {
            return node;
        }
        BNode<Integer> leftResult = findNode(node.left, value);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(node.right, value);
    }
    public void inOrder(){
        //t1 k t2
        System.out.println("Inorder: ");
        inOrderR(root);
        System.out.println();
    }
    public void inOrderR(BNode<T>n){
        if(n!=null){
            inOrderR(n.left);
            System.out.println(n.data.toString()+" ");
            inOrderR(n.right);
        }
    }
    public void preOrder(){
        System.out.println("Preorder: ");
        preOrderR(root);
        System.out.println();
    }
    public void preOrderR(BNode<T>n){
        if(n!=null){
         // k t1 t2
            System.out.println(n.data.toString()+" ");
            preOrderR(n.left);
            preOrderR(n.right);
        }
    }
    public void postOrder(){
        System.out.println("PostOrder: ");
        postOrderR(root);
        System.out.println();
    }
    public void postOrderR(BNode<T>n){
        if(n!=null){
            postOrderR(n.left);
            postOrderR(n.right);
            System.out.println(n.data.toString()+" ");
        }
    }
}
