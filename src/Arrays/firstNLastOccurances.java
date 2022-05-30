package Arrays;

public class firstNLastOccurances {
    public static int[] searchRange(int[] nums, int target) {
        int[] ar=new int[2];
        ar[0]=getStart(nums,target,0,nums.length-1);
        ar[1]=getEnd(nums,target,0,nums.length-1);
        return ar;
    }

    public static int getStart(int[] ar, int target,int l,int r){
        if(l<=r){
            int mid=(l+r)/2;
            if((mid==0 || target>ar[mid-1]) && ar[mid]==target) return mid;
            else if(ar[mid]<target) return getStart(ar,target,mid+1,r);
            else return getStart(ar,target,l,mid-1);
        }
        return -1;
    }

    public static int getEnd(int[] ar, int target,int l,int r){
        if(l<=r){
            int mid=(l+r)/2;
            if((mid==ar.length-1 || target<ar[mid+1]) && ar[mid]==target) return mid;
            else if(ar[mid]<=target) return getEnd(ar,target,mid+1,r);
            else return getEnd(ar,target,l,mid-1);
        }
        return -1;
    }
}
