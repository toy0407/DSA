package DynamicProgramming;

public class MinimumSumPartition {
    boolean[][] dp;
    public int minDifference(int ar[], int n)
    {
        // Your code goes here

        int sum=0;
        for(int i:ar){
            sum+=i;
        }
        dp=new boolean[n][sum+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    dp[i][j]=(j==ar[i]);
                }
                else{
                    boolean pick=false;
                    if(j-ar[i]>=0) pick=dp[i-1][j-ar[i]];
                    boolean npick=dp[i-1][j];
                    dp[i][j]=(pick || npick);
                }
            }

        }

        int min=(int)1e9;

        for(int i=0;i<=sum;i++){
            if(dp[n-1][i]==true){
                min=Math.min(min,Math.abs(i-(sum-i)));
            }
        }

        return min;

    }
}
