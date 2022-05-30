package LinkedList;

import java.io.IOException;
import java.util.Scanner;

import static LinkedList.ReverseLL.*;

public class DeleteNodeWithoutHead {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        ReverseLL.Node head = null;
        for (int i = 0; i < n; i++) {
            head = insertNode(head, sc.nextInt());
        }
        head.next.next=deleteNodeWithoutHead(head.next.next);
        printLL(head);
    }

    private static Node deleteNodeWithoutHead(Node node) {
        if (node==null) return node;
        if (node.next==null) return null;
        node.data=node.next.data;
        node.next=node.next.next;
        return node;
    }
}
