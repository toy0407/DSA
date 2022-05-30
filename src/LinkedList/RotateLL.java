package LinkedList;

import java.io.IOException;
import java.util.Scanner;

import static LinkedList.ReverseLL.insertNode;
import static LinkedList.ReverseLL.printLL;

public class RotateLL {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int k=(sc.nextInt())%n;
        ReverseLL.Node head = null;
        for (int i = 0; i < n; i++) {
            head = insertNode(head, sc.nextInt());
        }
        ReverseLL.Node nHead=rotateLL(head);
        printLL(nHead);

    }

    private static ReverseLL.Node rotateLL(ReverseLL.Node head) {
        ReverseLL.Node temp=head;
        while(temp.next.next!=null) temp=temp.next;
        temp.next.next=head;
        ReverseLL.Node nHead=temp.next;
        temp.next=null;
        return nHead;
    }
}
