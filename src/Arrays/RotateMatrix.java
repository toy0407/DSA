package Arrays;

public class RotateMatrix {
    public void rotate(int[][] ar) {
        int n=ar.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int t=ar[i][j];
                ar[i][j]=ar[j][i];
                ar[j][i]=t;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int t=ar[i][j];
                ar[i][j]=ar[i][n-1-j];
                ar[i][n-1-j]=t;
            }
        }
    }
}
