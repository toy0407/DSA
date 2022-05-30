package Arrays;

public class SmallestSubarrayWithsumGreaterThanX {
    public static int smallestSubWithSum(int a[], int n, int x) {
        int r=0,l=0,sum=0,min=Integer.MAX_VALUE;

        for(r=0;r<n;r++){
            sum+=a[r];
            if(sum>x){

                while(sum>x){
                    min=Math.min(min,r-l+1);
                    sum=sum-a[l++];

                }
            }
        }

        return min;
    }
}
