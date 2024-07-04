package tasks;

import java.util.Scanner;
import structures.*;
/*
 Create a function rearrange that modifies a singly linked list (SLL<Integer>) by moving all elements
 greater than or equal to a specified number to the end of the list, while preserving the relative order of 
 the other elements. 
 */

public class PartitionList {
    public static void rearrange(SLL<Integer>list,int number){
        SLLNode<Integer>tmp=list.getFirst();
        int counter=0,counter2=0;
        while(tmp!=null&& counter<list.length()-counter2){
            if(tmp.element>=number){
                counter++;
                SLLNode<Integer>save=tmp;
                list.delete(tmp);
                list.insertLast(save.element);
            }
            else{
                counter2++;
            }
            tmp=tmp.succ;
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
        int number= scan.nextInt();
        System.out.println("Original list: "+list.toString());
        rearrange(list,number);
        System.out.println("Rearranged list: "+list.toString());
    }

}
