package LinkedList;

import java.io.IOException;
import java.util.Scanner;

import static LinkedList.ReverseLL.insertNode;
import static LinkedList.ReverseLL.printLL;

public class removeNthNodeFromEnd {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int k=sc.nextInt();
        ReverseLL.Node head = null;
        for (int i = 0; i < n; i++) {
            head = insertNode(head, sc.nextInt());
        }

        head=removeNodeFromEnd(head,k);
        printLL(head);

    }

    private static ReverseLL.Node removeNodeFromEnd(ReverseLL.Node head, int k) {
        if (head==null) return head;
        ReverseLL.Node fp=head;
        ReverseLL.Node sp=head;
        int n=0;
        while(fp.next!=null){
            n++;
            if (n>k) sp=sp.next;
            fp=fp.next;
        }
        if (n>=k) {
            sp.next=sp.next.next;
            return head;
        }
        else return head;
    }
}
