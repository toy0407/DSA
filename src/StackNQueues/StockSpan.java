package StackNQueues;

import java.util.Stack;

public class StockSpan {
    //https://www.youtube.com/watch?v=XlD5VsOZsyA

    static class Pair{
        int val,c;
        Pair(int val,int c){
            this.val=val;
            this.c=c;
        }
    }
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Pair> s=new Stack<>();
        int[] ans=new int[n];
        int ind=0;
        for(int i=0;i<n;i++){
            int days=1;
            while(!s.isEmpty() && s.peek().val<=price[i]) {
                days+=s.peek().c;
                s.pop();
            }
            s.push(new Pair(price[i],days));
            ans[ind++]=days;
        }
        return ans;
    }
}
