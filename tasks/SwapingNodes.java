package tasks;

import java.util.Scanner;
import structures.*;
/*
 * Swap the values of the kth node from the beginning
 *  and the kth node from the end
 */
public class SwapingNodes{
    public static void change(SLL<Integer> list, int br) {
        int length = list.length();
        SLLNode<Integer> node1 = list.getFirst();
        SLLNode<Integer> node2 = list.getFirst();

        for (int i = 1; i < br; i++) {
            node1 = node1.succ;
        }
        for (int i = 1; i <= length - br ; i++) {
            node2 = node2.succ;
        }

        int temp = node1.element;
        node1.element = node2.element;
        node2.element = temp;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, br;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        br = scan.nextInt();
        change(list1,br);
        System.out.println(list1);
    }

}
