package Recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumWithRepetition {

    static List<List<Integer>> ans=new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        int target= sc.nextInt();
        for (int i=0;i<n;i++){
            ar[i]= sc.nextInt();
        }
        ArrayList<Integer> sol=new ArrayList<>();
        combinationSum(ar, target,sol,0);
        for (int i=0;i<ans.size();i++){
            System.out.println(Arrays.toString(ans.get(i).toArray()));
        }
    }

    private static void combinationSum(int[] ar, int target, ArrayList<Integer> sol, int sum) {
        if (sum==target){
            ans.add(new ArrayList<>(sol));
            return;
        }
        if (sum>target) return;
        for (int i=0;i<ar.length;i++){
            sol.add(ar[i]);
            combinationSum(Arrays.copyOfRange(ar,i,ar.length), target,sol,sum+ar[i]);
            sol.remove(sol.size()-1);
        }

    }
}
