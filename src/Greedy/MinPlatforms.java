package Greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinPlatforms {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] dep=new int[n];
        int i;
        for (i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for (i=0;i<n;i++){
            dep[i]=sc.nextInt();
        }
        int c=findPlatforms(arr,dep,n);
        System.out.println(c);


    }

    private static int findPlatforms(int[] arr, int[] dep, int n) {
        if (n==0 || n==1) return n;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int c=1,max=Integer.MIN_VALUE;
        for (int i=1;i<n;i++){
            if (arr[i]<=dep[i-1]) {
                c++;
                max=Math.max(c,max);
            }
            else c--;
        }
        return c;
    }
}
