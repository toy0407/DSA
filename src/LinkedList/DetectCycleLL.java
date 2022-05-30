package LinkedList;

import java.io.IOException;
import java.util.Scanner;

public class DetectCycleLL {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        ReverseLL.Node head1;
        head1=new ReverseLL.Node(1);
        head1.next=new ReverseLL.Node(2);
        head1.next.next=new ReverseLL.Node(3);
        head1.next.next.next=new ReverseLL.Node(4);
        head1.next.next.next.next=head1.next;
        System.out.println(detectCycle(head1));
    }

    static boolean detectCycle(ReverseLL.Node h1){
        ReverseLL.Node fp=h1,sp=h1;
        while (fp.next.next!=null){
            if (fp==sp) return true;
            fp=fp.next.next;
            sp=sp.next;
        }
        return false;
    }
}
