package TwoPointer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        int sum=sc.nextInt();
        for (int i=0;i<n;i++)
            ar[i]=sc.nextInt();
        print3sumSorting(ar,sum);
//        print3sumHashing(ar,sum);
        Arrays.asList(new int[]{1, 2, 3});
    }

    private static void print3sumHashing(int[] ar,int sum) {
    }

    private static void print3sumSorting(int[] ar,int sum) {
        Arrays.sort(ar);
        int i,j,k;
        for (i=0;i<ar.length;i++){
            for(j=i+1,k=ar.length-1;j<k;i++){
                if (ar[j]+ar[i]+ar[k]>sum) k--;
                else if (ar[i]+ar[j]+ar[k]<sum) j++;
                else {
                    System.out.println(ar[i]+" "+ar[j]+" "+ar[k]);
                    j++;k--;
                }
            }
        }
    }
}
