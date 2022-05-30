package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static Arrays.NoOfDigitsInFactorial.findDigits;

public class FactorialOfLargeNumber {

   static ArrayList<Integer> factorial(int N) {
        //code here
        ArrayList<Integer> ans = new ArrayList<>(500);
        int s=findDigits(N);
        for (int i=0;i<s;i++){
            ans.add(0);
        }
        ans.set(0,1);
        for (int i = 2; i <= N; i++) {
            int carry = 0;
            for (int j = 0; j <s ; j++) {
                int r = ans.get(j) * i + carry;
                if (r > 9) {
                    ans.set(j, r % 10);
                    carry = r / 10;
                } else {
                    ans.set(j, r);
                    carry=0;
                }
            }

        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
    }
}
