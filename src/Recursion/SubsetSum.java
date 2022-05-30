package Recursion;

import java.io.IOException;
import java.util.*;

public class SubsetSum {
    static ArrayList<Integer> ans=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        for (int i=0;i<n;i++){
            ar[i]= sc.nextInt();
        }
        int sum=0;
        getSubsetSum(ar,n,0,sum);
        Collections.sort(ans);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    private static void getSubsetSum(int[] ar, int n,int pos,int sum) {
        if (pos>n-1) {
            ans.add(sum);
            return;
        }
        getSubsetSum(ar,n,pos+1,sum+ar[pos]);
        getSubsetSum(ar,n,pos+1,sum);

    }
}
