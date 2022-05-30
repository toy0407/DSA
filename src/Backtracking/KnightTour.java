package Backtracking;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] ar=new int[n][n];
        for (int[] row : ar)
            Arrays.fill(row, 0);
        int[][] sol=new int[n][n];
        for (int[] row : sol)
            Arrays.fill(row, 0);
        boolean b=knightTour(ar,sol,n,0,0,0);
        if (b){
            print(sol,n);
        }
        else System.out.println("Not possible");
    }

    private static void print(int[][] sol,int n) {
        int i,j;
        for (i=0;i<n;i++){
            for (j=0;j<n;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean knightTour(int[][] ar, int[][] sol, int n,int x, int y,int c) {
        if (c==n*n) {
            return true;
        }
        if (isAvailable(ar,sol,n,x,y)){
            ar[x][y]=1;
            sol[x][y]=c;
            print(sol,n);
            if (knightTour(ar,sol,n,x+2,y+1,c+1)){
                return true;
            }
            if (knightTour(ar,sol,n,x+1,y+2,c+1)){
                return true;
            }
            if (knightTour(ar,sol,n,x-1,y+2,c+1)){
                return true;
            }
            if (knightTour(ar,sol,n,x-2,y+1,c+1)){
                return true;
            }
            if (knightTour(ar,sol,n,x-2,y-1,c+1)){
                return true;
            }
            if (knightTour(ar,sol,n,x-1,y-2,c+1)){
                return true;
            }
            if (knightTour(ar,sol,n,x+1,y-2,c+1)){
                return true;
            }
            if (knightTour(ar,sol,n,x+2,y-1,c+1)){
                return true;
            }
            ar[x][y]=0;
            sol[x][y]=0;
        }
        return false;
    }

    private static boolean isAvailable(int[][] ar, int[][] sol, int n, int x, int y) {
        if (x>=0 && x<n && y>=0 && y<n && ar[x][y]==0) return true;
        return false;
    }
}
