package DynamicProgramming;

import java.util.Arrays;

public class BurstBalloons {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int[] ar=new int[nums.length+2];
        dp= new int[ar.length][ar.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        ar[0]=ar[ar.length-1]=1;
        for(int i=0;i<nums.length;i++){
            ar[i+1]=nums[i];
        }
        return f(ar,1,nums.length);
    }

    int f(int[] ar,int i,int j){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        for(int k=i;k<=j;++k){
            int res = f(ar,i,k-1)+f(ar,k+1,j)+(ar[i-1]*ar[k]*ar[j+1]);
            ans=Math.max(ans,res);
        }
        return dp[i][j]=ans;
    }
}
