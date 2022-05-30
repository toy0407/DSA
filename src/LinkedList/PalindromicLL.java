package LinkedList;

import java.io.IOException;
import java.util.Scanner;

import static LinkedList.ReverseLL.*;

public class PalindromicLL {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        ReverseLL.Node head = null;
        for (int i = 0; i < n; i++) {
            head = insertNode(head, sc.nextInt());
        }
        boolean s=checkPalindrome(head);
        System.out.println(s);

    }

    private static boolean checkPalindrome(Node head) {
        Node sp=head,fp=head;
        while(fp.next!=null && fp.next.next!=null){
            sp=sp.next;fp=fp.next.next;
        }
        sp.next=reverseLLIterative(sp.next);
        sp=sp.next;
        Node d=head;
        while(sp!=null){
            if (d.data!=sp.data) return false;
            d=d.next;sp=sp.next;
        }
        return true;
    }
}
