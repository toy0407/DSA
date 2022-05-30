package DivideNConquer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SortedRotatedArray {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        int key=sc.nextInt();
        for (int i=0;i<n;i++) ar[i]=sc.nextInt();
        int p=getPivot(ar,0,n-1);
        int ans=search1(ar,key);
        System.out.println(p);
        System.out.println(ans);
    }

    //Method 1
    public static int search1(int[] ar, int target) {
        int l=0,r=ar.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(ar[mid]==target) return mid;
            if(ar[l]<=ar[mid]){
                if(ar[mid]>=target && target>=ar[l]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                if(target>=ar[mid] && target<=ar[r]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }

            }
        }
        return -1;
    }

    //Method 2
    private static int search2(int[] ar, int target) {
        int m=getPivot(ar,0,ar.length-1);
        if(m==ar.length-1) {
            int a= Arrays.binarySearch(ar,target);
            return a>=0?a:-1;
        }
        if(target>=ar[0] && target <=ar[m]){
            int a= Arrays.binarySearch(ar,0,m+1,target);
            return a>=0?a:-1;
        }
        else {
            int a=Arrays.binarySearch(ar,m+1,ar.length,target);
            return a>=0?a:-1;
        }
    }

    private static int getPivot(int[] ar, int l,int r) {
        int mid=(l+r)/2;
        if(mid!=ar.length-1 && ar[mid]>ar[mid+1]) return mid;
        if(mid==ar.length-1 || mid==0) return mid;
        if(ar[0]<ar[mid] && ar[mid]>ar[r]) return getPivot(ar,mid,r);
        else return getPivot(ar,l,mid);
    }
}
