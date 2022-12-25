package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    //Memoization
    int[][] dp;
    public int lengthOfLISmemoization(int[] nums) {
        int n=nums.length;
        dp= new int[n][n+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return f(nums,0,-1); //Here we are doing shifting of indices on the dp array itself instead of where the comparison is happening since the next can be -1.
    }
    int f(int[] ar, int i, int prev){
        if(i==ar.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int notTake=f(ar,i+1,prev);
        int take=0;
        if(prev==-1 || ar[prev]<ar[i]) take=1+f(ar,i+1,i);
        return dp[i][prev+1]=Math.max(take,notTake);
    }

    //Tabulation
    //2nd Variable always goes into +1 state since we are shifting coordinates
    public int lengthOfLIStabulation(int[] nums) {
        int n=nums.length;
        int[][] dp= new int[n+1][n+1];//taking 1st variable also as +1 due to line 32
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int notTake=dp[i+1][prev+1];
                int take=0;
                if(prev==-1 || nums[prev]<nums[i]) take=1+dp[i+1][i+1];
                dp[i][prev+1]=Math.max(take,notTake);
            }
        }
        return dp[0][-1+1];
    }

    //Tabulation (Simpler but unintuitive)
    public int lengthofLIStabular2(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(1+dp[j],dp[i]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    //Printing the LIS (Simpler but unintuitive)
    public int printLIS(int[] nums){
        int n=nums.length,maxIndex=0;
        int[] dp=new int[n];
        int[] h=new int[n];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<n;i++){
            h[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    h[i]=j;
                }
            }
           if(dp[i]>max){
               max=dp[i];
               maxIndex=i;
           }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(h[maxIndex]!=maxIndex){
            maxIndex=h[maxIndex];
            ans.add(nums[maxIndex]);
        }
        for (int i=ans.size()-1;i>=0;i--){
            System.out.println(ans.get(i));
        }
        return max;
    }

    //Binary Search
    int lisBS(int[] ar,int n){
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(ar[0]);
        for (int i = 1; i < n ; i++) {
            if(ar[i]>ans.get(ans.size()-1)){
                ans.add(ar[i]);
            }
            else{
                int replaceIndex= lower_bound(ans,ar[i]);
                ans.set(replaceIndex,ar[i]);
            }
        }
        return ans.size();
    }
    static int lower_bound(ArrayList<Integer> ar, int el){
        int l = 0, r = ar.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(ar.get(mid)==el) return mid;
            else if (ar.get(mid)>el) r = mid-1;
            else l = mid+1;
        }
        return l;
    }



}
