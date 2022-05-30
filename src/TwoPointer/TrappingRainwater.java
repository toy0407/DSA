package TwoPointer;

import java.util.Scanner;

public class TrappingRainwater {
    public static int trap(int[] height) {
        int n=height.length,i;
        int[] maxR=new int[n];
        int[] maxL=new int[n];
        int max=Integer.MIN_VALUE;
        for(i=0;i<n;i++){
            if(height[i]>=max) max=height[i];
            maxL[i]=max;
        }
        max=Integer.MIN_VALUE;
        for(i=n-1;i>=0;i--){
            if(height[i]>=max) max=height[i];
            maxR[i]=max;
        }
        int s=0;
        for(i=0;i<n;i++){
            s+=Math.min(maxL[i],maxR[i])-height[i];
        }
        return s;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        for(int i=0;i<n;i++) ar[i]=sc.nextInt();
        System.out.println(trap(ar));
    }
}
