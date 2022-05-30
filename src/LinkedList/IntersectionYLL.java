package LinkedList;

import java.io.IOException;
import java.util.Scanner;

import static LinkedList.ReverseLL.*;

public class IntersectionYLL {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        ReverseLL.Node head1,head2;
        head1=new Node(1);
        head1.next=new Node(2);
        head1.next.next=new Node(3);
        head1.next.next.next=new Node(4);

        head2=new Node(9);
        head2.next=new Node(6);
        head2.next.next=head1.next.next;


        ReverseLL.Node node=getIntersection(head1,head2);
        if (node==null) System.out.println(-1);
        else System.out.println(node.data);
    }

    static Node getIntersection(Node h1,Node h2){
        Node d1=h1,d2=h2;
        int c1=0,c2=0;
        while(d1!=null || d2!=null){
            if (d1!=null) {
                c1++;
                d1=d1.next;
            }
            if (d2!=null) {
                c2++;
                d2=d2.next;
            }
        }
        d1=h1;d2=h2;
        if (c1>c2){
            int c=c1-c2;
            while(c>0){
                d1=d1.next;
                c--;
            }
            while(d1!=null && d2!=null){
                if (d1==d2) return d1;
                d1=d1.next;d2=d2.next;
            }
        }
        else {
            int c=c2-c1;
            while(c>0){
                d2=d2.next;
                c--;
            }
            while(d1!=null && d2!=null){
                if (d1==d2) return d1;
                d1=d1.next;d2=d2.next;
            }

        }
        return null;
    }

}
