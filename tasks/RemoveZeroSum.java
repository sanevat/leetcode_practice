package tasks;

import java.util.Scanner;
import structures.*;
/*
 * delete consecutive sequences of nodes that
 *  sum to 0 until there are no such sequences.
 */

public class RemoveZeroSum {
    public static void change(SLL<Integer>list){
        SLLNode<Integer>tmp=list.getFirst();
        while(tmp!=null&& tmp.succ!=null){
            boolean flag=false;
            int sum= tmp.element;
            SLLNode<Integer>pom=tmp.succ;
            while(pom!=null){
                sum+=pom.element;
                if(sum==0) break;
                pom=pom.succ;
            }
            if(sum==0){
                flag=true;
                while(tmp!=pom.succ){
                   list.delete(tmp);
                   tmp=tmp.succ;
               }
            }
            if(flag){
                tmp=list.getFirst();
            } 
            else{
                tmp=tmp.succ;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        System.out.println("Original list:"+list1);
        change(list1);
        System.out.println("Modified list:"+list1);
    }
}
