package tasks;

import java.util.Scanner;
import structures.*;
/*
 * The task described by the ReorderList class and its reorder method is to reorder a singly linked list (SLL<Integer> list) 
 * such that each pair of adjacent nodes is swapped. 
 */


public class ReorderList {

    public static void reorder(SLL<Integer> list) {
       SLLNode<Integer>tmp=list.getFirst();
       while(tmp.succ!=null&& tmp.succ.succ!=null){
           SLLNode<Integer>last=list.getLastNode();
           list.delete(last);
           list.insertAfter(last.element,tmp);
           tmp=tmp.succ.succ;
       }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        SLL<Integer> list = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list.insertLast(scan.nextInt());
        }
        System.out.println("Original list: "+list);
        reorder(list);
        System.out.println("Reordered list:"+list);


    }
}

