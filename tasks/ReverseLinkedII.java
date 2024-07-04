package tasks;

import java.util.Scanner;
import structures.*;
/*
Implement a reverse method that accepts the singly linked list (list) 
and two integer parameters, left and right.Reverse the sublist of the singly linked list from index left to right
inclusive. Maintain the rest of the list (elements outside the specified range) in their original order.
 */
public class ReverseLinkedII {
    public static void reverse(SLL<Integer> list, int left, int right){
        SLLNode<Integer>tmp=list.getFirst();
        int counterLeft=1, counterRight=1;
        while(tmp!=null){
            if(counterLeft>=left&& counterLeft<=right){
                SLLNode<Integer>toDelete=tmp;
                list.delete(toDelete);
                list.insertFirst(toDelete.element);
            }
            tmp=tmp.succ;
            counterLeft++;
        }
        tmp=list.getFirst();
        counterLeft=1;
        while(tmp!=null){
            if(counterLeft>=right && counterRight<=left-1){
                SLLNode<Integer>toDelete=tmp;
                list.delete(toDelete);
                list.insertFirst(toDelete.element);
                counterRight++;
            }
            counterLeft++;
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
        int left = scan.nextInt();
        int right=scan.nextInt();
        reverse(list,left,right);
        System.out.println("Reversed list:"+list);
    }
}
