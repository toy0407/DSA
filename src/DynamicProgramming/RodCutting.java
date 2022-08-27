package DynamicProgramming;

import java.util.Arrays;

public class RodCutting {

    //https://www.youtube.com/watch?v=mO8XpGoJwuo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=25

    //Recursion + Memoization
    int[][] dp;
    public int cutRodMemoization(int[] price, int n) {
        //code here
        dp=new int[n+1][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return f(price,n,n-1);
    }
    int f(int[] price,int n, int i){
        if(i==0) return n*price[0];
        if(dp[n][i]!=-1) return dp[n][i];
        int notPick=f(price,n, i-1);
        int pick=(int)-1e9;
        if(i+1<=n) pick=price[i]+f(price,n-(i+1),i); //rod length = i+1 since array indexes are 0-based
        return dp[n][i]=Math.max(pick, notPick);
    }

    //Tabulation
    public int cutRodTabulation(int[] price, int n) {
        //code here
        int[][] dp=new int[n+1][n];

        for(int j=0;j<n+1;j++) dp[j][0] = j * price[0];

        for(int i=0;i<=n;i++){
            for(int j=1;j<n;j++){
                int notPick=dp[i][j-1];
                int pick=(int)-1e9;
                if(j+1<=i) pick=price[j]+dp[i-(j+1)][j]; //rod length = j+1 since array indexes are 0-based
                dp[i][j]=Math.max(pick, notPick);
            }
        }
        return dp[n][n-1];
    }

}
