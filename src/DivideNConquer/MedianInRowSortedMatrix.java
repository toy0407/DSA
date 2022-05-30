package DivideNConquer;

import java.io.IOException;
import java.util.Scanner;

public class MedianInRowSortedMatrix {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int i,j;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int[][] ar=new int[r][c];
        for (i=0;i<r;i++){
            for (j=0;j<c;j++){
                ar[i][j]=sc.nextInt();
                max=Math.max(max,ar[i][j]);
                min=Math.min(min,ar[i][j]);
            }
        }
        int s=getMedianInMatrix(ar,r,c,max,min);
        System.out.println(s);
        
    }

    private static int getMedianInMatrix(int[][] ar, int r, int c, int max, int min) {
        int mid=(max+min)/2;
        int n=r*c;
        if (searchMatrix(ar,r,c,mid)==n/2){
            return mid;
        }
        if (searchMatrix(ar,r,c,mid)<n/2){
            return getMedianInMatrix(ar,r,c,max,mid);
        }
        if (searchMatrix(ar,r,c,mid)>n/2){
            return getMedianInMatrix(ar,r,c,mid,min);
        }
        return -1;
    }

    private static int searchMatrix(int[][] ar,int r, int c, int mid) {
        int count=0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (ar[i][j]<mid) count++;
            }
        }
        return count;
    }
}
