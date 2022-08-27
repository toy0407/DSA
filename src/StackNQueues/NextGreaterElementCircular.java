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

    public static int[] getNextGreaterElementArray(int[] ar) {
        Stack<Integer> s=new Stack<>();
        int n=ar.length;
        int[] ans=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=ar[i%n]){
                s.pop();
            }
            if(i<n){
                if(!s.isEmpty()) ans[i]=s.peek();
                else ans[i]=-1;
            }
            s.push(ar[i%n]);
        }
        return ans;
    }
}
