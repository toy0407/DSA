package BinarySearch;

public class BookAllocation {
    public static int findPages(int[] ar,int n,int m)
    {
        //Your code here
        int l=0,r=0;
        for(int i=0;i<n;i++){
            r+=ar[i];
            l=Math.max(l,ar[i]);
        }
        int ans=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(ar,m,mid)){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }

    static boolean isPossible(int[] ar,int k,int s){
        int sum=0,p=1;
        for(int i=0;i<ar.length;i++){
            sum+=ar[i];
            if(sum>s){
                p++;
                sum=ar[i];
            }
            if(p>k) return false;
        }
        return true;
    }
}
