package Backtracking;

import java.io.IOException;
import java.util.Scanner;

public class RatInMaze {
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] ar=new int[n][n];
        int[][] sol=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                ar[i][j]=sc.nextInt();
            }
        }
        ratInMaze(ar,n,0,0,sol);
        printSol(sol,n);
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

    private static boolean ratInMaze(int[][] ar,int n, int x, int y,int[][] sol) {
        if (x==n-1 && y==n-1){
            sol[x][y]=1;
            return true;
        }
        if (isSafe(ar,n,x,y)){
            sol[x][y]=1;
            if (ratInMaze(ar,n,x,y+1,sol)) return true;
            if (ratInMaze(ar,n,x+1,y,sol)) return true;
            sol[x][y]=0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int[][] ar, int n, int x, int y) {
        if (x<n && y<n && ar[x][y]==1) return true;
        return false;
    }
}
