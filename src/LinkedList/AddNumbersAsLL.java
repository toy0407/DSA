package LinkedList;

import java.io.IOException;
import java.util.Scanner;

import static LinkedList.ReverseLL.insertNode;
import static LinkedList.ReverseLL.printLL;

public class AddNumbersAsLL {
    public static void main(String[] args) throws IOException{
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

        ReverseLL.Node sHead=null;
        sHead=addAsLL(head1,head2,0,sHead);
        printLL(sHead);
    }

    private static ReverseLL.Node addAsLL(ReverseLL.Node head1, ReverseLL.Node head2, int carry, ReverseLL.Node shead) {
        shead =new ReverseLL.Node();
        if (head1==null && head2==null){
            return new ReverseLL.Node(carry);
        }
        if (head1==null){
            head2.data=head2.data+carry;
            return head2;
        }
        if (head2==null){
            head1.data=head1.data+carry;
            return head1;
        }
        if (head1.data+ head2.data+carry>=10){
            shead.data= (head1.data+ head2.data+carry)%10;
            shead.next= addAsLL(head1.next,head2.next,1,shead.next);
            return shead;
        }
        else{
            shead.data= head1.data+ head2.data+carry;
            shead.next= addAsLL(head1.next,head2.next,0,shead.next);
            return shead;
        }
    }
}
