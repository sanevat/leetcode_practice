package tasks;

import java.util.Scanner;
import structures.*;
/*A linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.
For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes.
The modified list should not contain any 0's. */
public class MergeNodesBetweenZeros {
    public static void mergeZeros(SLL<Integer> list) {
        SLLNode<Integer> current = list.getFirst();
        SLLNode<Integer> prevZero = null;
        int sum = 0;
        boolean firstZeroProcessed = false;

        while (current != null) {
            if (current.element == 0) {
                if (firstZeroProcessed && sum != 0) {
                    prevZero.succ = new SLLNode<>(sum, current.succ);
                    prevZero = prevZero.succ;
                    sum = 0;
                } else if (!firstZeroProcessed) {
                    firstZeroProcessed = true;
                    prevZero = current;
                }
            } else {
                sum += current.element;
            }
            current = current.succ;
        }

        if (prevZero != null) {
            prevZero.succ = null;
        }
        SLLNode<Integer>first= list.getFirst();
        if (first != null && first.element == 0) {
            list.first= first.succ;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }
        mergeZeros(list);
        System.out.println(list);
    }
}
