package LinkedList;

import java.io.IOException;
import java.util.Scanner;

import static LinkedList.ReverseLL.insertNode;

public class middleOfLL {
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        ReverseLL.Node head = null;
        for (int i = 0; i < n; i++) {
            head = insertNode(head, sc.nextInt());
        }
        int mid=getMiddleElement(head);
        System.out.println(mid);
    }

    private static int getMiddleElement(ReverseLL.Node head) {
        if (head==null) return -1;
        if (head.next==null) return head.data;
        ReverseLL.Node temp=head;
        ReverseLL.Node stemp=head;
        while(temp!=null && temp.next!=null){
            stemp=stemp.next;
            temp=temp.next.next;
        }
        return stemp.data;

    }
}
