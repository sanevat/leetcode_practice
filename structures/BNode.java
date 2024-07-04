package structures;
public class BNode<T extends Comparable<T>>{
    public T data;
    public BNode<T> left;
    public BNode<T> right;
    static int LEFT=1;
    static int RIGHT=2;
     public BNode(T data){
         this.data=data;
         left=null;
         right=null;
     }
    public BNode(){
        this.data=null;
        left=null;
        right=null;
    }
    public BNode(T data, BNode<T> left, BNode<T> right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }

     @Override
     public String toString() {
         return ""+data;
     }
 }