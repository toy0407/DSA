package Backtracking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AllPermutations {
    static ArrayList<String> ans=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int i;
        String s=sc.nextLine();
        String sol=new String();
        permutations(s,sol);
        System.out.println(ans.toString());
    }

    private static void permutations(String s,String sol) {
        if (s.length()==0) {
            ans.add(sol);
            return;
        }
        for (int i=0;i<s.length();i++){
            permutations(s.substring(0,i)+s.substring(i+1),s.charAt(i)+sol);
        }
    }
}
