package Recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationSequence {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String ans="";
        System.out.println(getPermutationSequence(n,k));
    }

    private static String getPermutationSequence(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1;i<n;i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        while(true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if(numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans;
    }

    private static int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }
}
