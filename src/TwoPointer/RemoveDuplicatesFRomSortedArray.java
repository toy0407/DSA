package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesFRomSortedArray {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        int i;
        for (i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
        int count=removeDuplicates(ar,n);
        System.out.println(Arrays.toString(ar));
        System.out.println(count);
    }

    private static int removeDuplicates(int[] ar,int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int i,c=0,count=1;
        for (i=1;i<n;i++){
            if (ar[i]!=ar[c]){
                c++;
                ar[c]=ar[i];
                count++;
            }
        }
        return count;

    }
}
