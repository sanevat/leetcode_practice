package tasks;
import java.util.Scanner;

import structures.*;
/*Remove Consecutive Positive Integers:

If two consecutive nodes both have positive integers, delete the second node.
Handle Consecutive Negative Integers:

If two consecutive nodes both have negative integers, insert a new node with the absolute value of the first negative integer immediately after it.
Remove Zeroes:

If a node has a value of zero, delete it. If the successor node has a value of zero, delete it. */

public class ZigZag {
    public static void rearrange(SLL<Integer>list){
        SLLNode<Integer>tmp=list.getFirst();
        if(list.length()==1){
            return;
        }
        int flag=0;
        while(tmp!=null&& tmp.succ!=null){
            if(tmp.element>0&& tmp.succ.element>0){
                flag=1;
                list.delete(tmp.succ);
            }
            else if(tmp.element<0&& tmp.succ.element<0){
                flag=1;
                int newNode=Math.abs(tmp.element);
                list.insertAfter(newNode,tmp);
            }
            else if(tmp.element==0 ||tmp.succ.element==0){
                flag=1;
                if(tmp.element==0)list.delete(tmp);
                if(tmp.succ.element==0)list.delete(tmp.succ);
            }
            if(flag==1){
                flag=0;
                tmp=list.getFirst();
            }else{
                flag=0;
                tmp=tmp.succ;
            }
        }
        if(tmp!=null){
            if(tmp.element==0){
                list.deleteList();
            }
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }
        System.out.println("Original list:"+list);
        rearrange(list);
        System.out.println("Zig Zag lst:"+list.toString());
    }
}
