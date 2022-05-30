package LinkedList;

import java.io.IOException;
import java.util.Scanner;

import static LinkedList.ReverseLL.insertNode;

public class merge2LLInplace {
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
        int n1 = sc.nextInt();
        ReverseLL.Node head1 = null;
        for (int i = 0; i < n1; i++) {
            head1 = insertNode(head1, sc.nextInt());
        }
        int n2 = sc.nextInt();
        ReverseLL.Node head2 = null;
        for (int i = 0; i < n2; i++) {
            head2 = insertNode(head2, sc.nextInt());
        }

        ReverseLL.Node head3=mergeLL(head1,head2);

    }

    public static ReverseLL.Node mergeLL(ReverseLL.Node head1, ReverseLL.Node head2) {
        if (head1==null) return head2;
        if (head2==null) return head1;

        if (head1.data<head2.data){
            head1.next=mergeLL(head1.next,head2);
            return head1;
        }
        else {
            head2.next=mergeLL(head1,head2.next);
            return head2;
        }
        
    }
}
