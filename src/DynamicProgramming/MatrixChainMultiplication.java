package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {

    //Recursive
    static int[][] dp;
    static int matrixMultiplicationRecursive(int N, int[] arr)
    {
        // code here
        dp=new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }

        return f(arr,1,N-1);
    }
    static int f(int[] ar,int i,int j){
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost=f(ar,i,k)+f(ar,k+1,j)+(ar[i-1]*ar[j]*ar[k]);
            ans=Math.min(ans,cost);
        }
        return dp[i][j]=ans;
    }

    //
}
