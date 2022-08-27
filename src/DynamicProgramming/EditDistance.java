package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {

    //https://www.youtube.com/watch?v=fJaKO8FbDdo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=34

    // Recursion + Memoization
    int[][] dp;
    public int minDistanceMemoization(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        dp=new int[n+1][m+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return f(n,m,word1,word2);
    }
    int f(int i,int j, String s1, String s2){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)) return dp[i][j]=f(i-1,j-1,s1,s2);
        return dp[i][j]= 1 + Math.min(f(i,j-1,s1,s2),Math.min(f(i-1,j,s1,s2),f(i-1,j-1,s1,s2)));
    }

    // Tabulation
    public int minDistanceTabulation(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=i;
        for(int i=0;i<=m;i++) dp[0][i]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]= 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }
        return dp[n][m];
    }
}
