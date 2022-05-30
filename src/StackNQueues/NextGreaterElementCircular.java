package StackNQueues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementCircular {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        for (int i=0;i<n;i++) ar[i]=sc.nextInt();
        int[] ans=getNextGreaterElementArray(ar);

    }

    private static int[] getNextGreaterElementArray(int[] ar) {
        int i;
        int[] ans=new int[ar.length];
        Stack<Integer> stack=new Stack<>();
        for (i=ar.length-2;i>=0;i--){
            //TODO: INCOMPLETE
        }
        return ans;
    }
}
