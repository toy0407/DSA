package Arrays;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i,j;
        int r=matrix.length,c=matrix[0].length;
        for( i=0;i<r;i++){
            if(matrix[i][0]<=target && matrix[i][c-1]>=target) return bSearch(matrix,target,0,c-1,i);
        }
        return false;
    }

    public boolean bSearch(int[][] ar,int target,int l, int r,int c){
        if(r>=l){
            int mid=(l+r)/2;
            if(ar[c][mid]==target) return true;
            if(ar[c][mid]<target) return bSearch(ar,target,mid+1,r,c);
            else if(ar[c][mid]>target) return bSearch(ar,target,l,mid-1,c);
        }
        return false;
    }
}
