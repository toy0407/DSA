package Arrays;

import java.io.IOException;
import java.util.*;

public class PascalTriangle {
    public static List<List<Long>> generate(int n) {
        List<List<Long>> ans=new ArrayList();
        long[][] ar=new long[n+1][n+1];
        for(int i=1;i<=n;i++){

            for(int j=1;j<=i;j++){
                if(i>2 && j-1>=1 && j<=i){
                    ar[i][j]=ar[i-1][j-1]+ar[i-1][j];
                }
                else ar[i][j]=1;
            }
        }
        for(int i=1;i<=n;i++){
            List<Long> a=new ArrayList<>();
            for(int j=1;j<=i;j++){
                a.add(ar[i][j]);
            }
            ans.add(a);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Long>> ans=generate(n);
        for (int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++)
                System.out.print(ans.get(i).get(j)+" ");
            System.out.println();
        }

    }
}
