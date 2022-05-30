package Arrays;
import java.util.*;

public class PascalTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        long t=1;
        ans.add((int) t);
        for(int i=0;i<rowIndex;i++){
            t=t*(rowIndex-i)/(i+1);
            ans.add((int) t);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> ans=getRow(n);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
