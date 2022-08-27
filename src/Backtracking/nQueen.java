package Backtracking;

import java.io.IOException;
import java.util.Scanner;

public class nQueen {
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] ar=new int[n][n];
        getQueenPosition(ar,n,0);
        printSol(ar,n);
    }

    private static void printSol(int[][] sol, int n) {
        int i,j;
        for(i=0;i<n;i++){
            for (j=0;j<n;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean getQueenPosition(int[][] ar, int n,int x) {
            if (x==n) {
                return true;
            }
            for (int i=0;i<n;i++){
                if (isSafe(ar,n,x,i)){
                    ar[x][i]=1;
                    if (getQueenPosition(ar,n,x+1)) return true;
                    ar[x][i]=0;
                }
            }
            return false;
    }

    private static boolean isSafe(int[][] ar, int n,int x,int y) {
        int i,j;
        for (i=x,j=y;i>=0 && j>=0;i--,j--){
            if (ar[i][j]==1) return false;
        }
        for (i=x,j=y;i>=0 && j<n;i--,j++){
            if (ar[i][j]==1) return false;
        }
        for (i=x,j=y;i>=0;i--){
            if (ar[i][j]==1) return false;
        }
        return true;
    }
}
