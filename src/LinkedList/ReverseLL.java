package LinkedList;

import java.io.IOException;
import java.util.Scanner;

public class ReverseLL {
    static class Node{
        int data;
        Node next;
        Node bottom;

        public Node(int data) {
            this.data=data;
        }

        public Node() {

        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) {
            head = insertNode(head, sc.nextInt());
        }
//        head=reverseLLIterative(head);
        head = reverseLLRecursive(head);

        printLL(head);

    }

    static Node reverseLLIterative(Node head) {
        Node prev=null;
        Node curr=head;
        Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    static Node reverseLLRecursive(Node head) {
        if (head==null || head.next==null) return head;
        Node rest=reverseLLRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return rest;
    }

    public static Node insertNode(Node head, int data){
        if (head==null){
            Node node=new Node(data);
            return node;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(data);
        return head;
    }

    public static void printLL(Node head) {
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
