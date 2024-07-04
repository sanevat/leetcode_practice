package tasks;

/*
 * Given the heads of two singly linked-lists headA and headB, 
 * return the node at which the two lists intersect. 
 */
import java.util.Scanner;

import structures.*;

public class IntersectionOfLinkedLists {
    public static boolean intersect(SLL<Integer> l1, SLL<Integer> l2, int b, int skipA, int skipB) {
        SLLNode<Integer> tmpA = l1.getFirst();
        SLLNode<Integer> tmpB = l2.getFirst();
        for (int i = 1; i < skipA && tmpA != null; i++) {
            tmpA = tmpA.succ;
        }
        for (int i = 1; i < skipB && tmpB != null; i++) {
            tmpB = tmpB.succ;
        }
        while (tmpA != null && tmpB != null) {
            if (tmpA.element == tmpB.element && tmpA.element == b) {
                return true;
            }
            tmpA = tmpA.succ;
            tmpB = tmpB.succ;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        SLL<Integer> list1 = new SLL<Integer>();
        SLL<Integer> list2 = new SLL<Integer>();
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            list1.insertLast(scan.nextInt());
        }
        m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            list2.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        int skipA = scan.nextInt(), skipB = scan.nextInt();
        if (intersect(list1, list2, br, skipA, skipB) == true) {
            System.out.println("Intersected at: " + br);
        } else {
            System.out.println("No intersections");
        }

    }
}
