package DynamicProgramming;

public class CoinChange1 {

    //Minimum coins to obtain target
    //https://www.youtube.com/watch?v=myPeWb3Y68A&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=21

    //Recursion + Memoization
    int[][] dp;
    public int coinChangeMemoization(int[] coins, int amount) {
        dp=new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int c=f(coins.length-1,coins,amount);
        return c==(int)1e9?-1:c;
    }
    int f(int i, int[] coins, int amt){
        if(i==0){
            if(amt%coins[i]==0) return amt/coins[i];
            else return (int)1e9;
        }
        if(dp[i][amt]!=-1) return dp[i][amt];
        int notTake= f(i-1,coins,amt);
        int take=(int) 1e9;
        if(amt>=coins[i]) take=1+f(i,coins,amt-coins[i]);
        return dp[i][amt]=Math.min(notTake,take);
    }


    // Tabulation
    public int coinChangeTabulation(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i] = (int)1e9;
        }
        for(int i=1;i<n;i++){
            for(int amt=0;amt<=amount;amt++){
                int notTake= dp[i-1][amt];
                int take=(int) 1e9;
                if(amt>=coins[i]) take=1+dp[i][amt-coins[i]];
                dp[i][amt]=Math.min(notTake,take);
            }
        }
        int c=dp[n-1][amount];
        return c==(int)1e9?-1:c;
    }

}
