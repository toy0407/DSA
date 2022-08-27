package DynamicProgramming;

public class EqualSubsetSumPartition {

    //https://www.youtube.com/watch?v=7win3dcgo3k&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=16

    //Recursion + Memoization
    int[][] dp;
    public boolean canPartitionMemoization(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0) return false;
        else{
            dp=new int[nums.length+1][20001];
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<20001;j++){
                    dp[i][j]=-1;
                }
            }
            return auxFunc(nums,nums.length-1,sum/2)==1;
        }
    }
    int auxFunc(int[] nums,int i,int sum){
        if(i<0 || sum<0) return 0;
        if(sum==0) return 1;
        if(dp[i][sum]!=-1) return dp[i][sum];
        dp[i][sum]=auxFunc(nums,i-1,sum-nums[i]) | auxFunc(nums,i-1,sum);
        return dp[i][sum];
    }



    //Tabulation
    public boolean canPartitionTabulation(int[] nums) {
        int k=0,n=nums.length;
        if(n==0 || n==1) return false;
        for(int i=0;i<nums.length;i++){
            k=k+nums[i];
        }
        if(k%2!=0) return false;
        k=k/2;
        dp=new int[n][2*k+1];
        for (int i = 0; i < n; i++) dp[i][0] = 1;
        dp[0][nums[0]]=1;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {
                boolean pick = false;
                if(nums[i]<=target) pick=dp[i - 1][target - nums[i]] == 1;
                boolean notPick = dp[i-1][target] == 1;
                dp[i][target] = (pick || notPick) ? 1 : 0;
            }
        }
        return dp[n-1][k]==1;
    }
}
