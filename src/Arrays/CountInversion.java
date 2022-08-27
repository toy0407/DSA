package Arrays;

public class CountInversion {
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr,0,(int)N-1);

    }

    static long mergeSort(long[] ar,int l,int r){
        long inv=0;
        if (l<r){
            int mid=(l+r)/2;
            inv+=mergeSort(ar,l,mid);
            inv+=mergeSort(ar,mid+1,r);
            inv+=merge(ar,l,mid,r);
        }
        return inv;
    }

    static long merge(long[] ar,int l,int mid, int r){
        long inv=0;
        int nl=mid-l+1;
        int nr=r-mid;
        long[] a=new long[nl];
        long[] b=new long[nr];
        for(int i=0;i<nl;i++){
            a[i]=ar[l+i];
        }
        for(int i=0;i<nr;i++){
            b[i]=ar[mid+1+i];
        }
        int i=0,j=0,k=l;
        while(i<nl && j<nr){
            if(a[i]<=b[j]){
                ar[k++]=a[i++];

            }
            else{
                ar[k++]=b[j++];
                inv+=nl-i;
            }
        }
        while(i<nl){
            ar[k++]=a[i++];
        }
        while(j<nr){
            ar[k++]=b[j++];
        }
        return inv;
    }
}
