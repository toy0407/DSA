package DynamicProgramming;

import java.util.Arrays;

public class SubsetSum {

    //https://www.youtube.com/watch?v=fWX9xDmIzRI&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=15&t=1s
    
    //Recursive + Memoization
    int[][] dp;
    boolean f(int[] ar, int i, int k){
        if(k==0) return true;
        if(i==0) return ar[i]==k;
        if(dp[i][k]!=-1) return dp[i][k]==1;
        boolean pick= false;
        if (ar[i]<=k) f(ar,i-1,k-ar[i]);
        boolean notPick=f(ar,i-1,k);
        dp[i][k]= (pick || notPick) ?1:0;
        return dp[i][k]==1;
    }
    boolean subsetSumToKmemoization(int[] ar,int n, int k){
        dp=new int[n][k+1];
        for (int[] a:dp) Arrays.fill(a,-1);
        return f(ar,k,n-1);
    }

    //Tabulation
    boolean subsetSumToKTabulation(int[] ar,int k, int n){
        dp=new int[n][k+1];
        for (int i = 0; i < n; i++) dp[i][0] = 1;
        dp[0][ar[0]]=1;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {
                boolean pick = false;
                if(ar[i]<=target) pick=dp[i - 1][target - ar[i]] == 1;
                boolean notPick = dp[i-1][target] == 1;
                dp[i][target] = (pick || notPick) ? 1 : 0;
            }
        }
        return dp[n-1][k]==1;
    }



}
