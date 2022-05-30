package Recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumWithoutRepetitioin {
    static List<List<Integer>> ans=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        int target= sc.nextInt();
        for (int i=0;i<n;i++){
            ar[i]= sc.nextInt();
        }
        Arrays.sort(ar);
        ArrayList<Integer> sol=new ArrayList<>();
        combinationSum(ar, target,sol,0);
        for (int i=0;i<ans.size();i++){
            System.out.println(Arrays.toString(ans.get(i).toArray()));
        }
    }

    private static void combinationSum(int[] ar, int target, ArrayList<Integer> sol, int sum) {
        if (target==sum) {
            ans.add(new ArrayList<>(sol));
            return;
        }
        if (sum>target) return;
        for (int i=0;i<ar.length;i++){
            if (i>0 && ar[i]==ar[i-1]) continue;
            sol.add(ar[i]);
            combinationSum(Arrays.copyOfRange(ar,i+1,ar.length),target,sol,sum+ar[i]);
            sol.remove(sol.size()-1);
        }
    }
}
