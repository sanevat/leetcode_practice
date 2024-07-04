package tasks;

import java.util.Scanner;

import structures.SLL;
import structures.SLLNode;

public class RemoveDuplicates {
    public static void removeDuplicates(SLL<Integer> list) {
        SLLNode<Integer> current = list.getFirst();
        
        while (current != null) {
            SLLNode<Integer> runner = current;
            while (runner.succ != null) {
                if (runner.succ.element.equals(current.element)) {
                    runner.succ = runner.succ.succ; 
                } else {
                    runner = runner.succ;
                }
            }
            current = current.succ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        System.out.println("Original list: " +list);
        removeDuplicates(list);
        System.out.println("List with removed duplicates: "+list.toString());
    }
}