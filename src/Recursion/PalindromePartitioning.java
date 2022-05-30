package Recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {

    static List<List<String>> ans=new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        List<String> sol=new ArrayList<>();
        partitionString(s,sol);

        for (int i=0;i<ans.size();i++){
            System.out.println(Arrays.toString(ans.get(i).toArray()));
        }

    }

    private static void partitionString(String s, List<String> sol) {
        if (s.length()==0){
            ans.add(new ArrayList<>(sol));
            return;
        }

        for (int i=0;i<s.length();i++){
            if (isPalindrome(s.substring(0,i+1))){
                sol.add(s.substring(0,i+1));
                partitionString(s.substring(i+1),sol);
                sol.remove(sol.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<j){
            if (s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}
