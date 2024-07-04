package tasks;

import java.util.ArrayList;
import java.util.Scanner;
import structures.*;

/*
 * For each node in the list, find the value of the next greater node. 
 * That is, for each node, find the value of the first node that is next
 *  to it and has a strictly larger value than it.
 */

public class NextGreaterNode {
    public static SLL<Integer> nextGreater(SLL<Integer> list) {
        SLL<Integer> niza = new SLL<>();
        SLLNode<Integer> tmp = list.getFirst();
        while (tmp != null) {
            SLLNode<Integer> pom = tmp.succ;
            int nextGreater = 0; 
            while (pom != null) {
                if (pom.element > tmp.element) {
                    nextGreater = pom.element;
                    break;
                }
                pom = pom.succ;
            }
    
            niza.insertLast(nextGreater);
            
            tmp = tmp.succ;
        }
        return niza;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        System.out.println("Original list:" + list1);
        SLL<Integer>niz=nextGreater(list1);
        System.out.println("Modified list:"+niz.toString());
    }
}
