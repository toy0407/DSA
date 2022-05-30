package DivideNConquer;

import java.io.IOException;
import java.util.Scanner;

public class NumberOnceInSortedArray {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        for (int i=0;i<n;i++)
            ar[i]=sc.nextInt();
        int s=getNumber(ar,0,n-1);
        System.out.println(s);
    }

    private static int getNumber(int[] ar, int l, int r) {
        int mid=l+(r-l)/2;
        if (l>r) return -1;
        if (l==r) return ar[l];

        if (mid%2==0){
            if (ar[mid]==ar[mid+1]) return getNumber(ar,mid+2,r);
            else return getNumber(ar,l,mid);
        }
        else {
            if (ar[mid]==ar[mid-1]) return getNumber(ar,mid+1,r);
            else return getNumber(ar,l,mid-1);
        }
    }
}
