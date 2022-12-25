package Greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MinPlatforms {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dep = new int[n];
        int i;
        for (i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (i = 0; i < n; i++) {
            dep[i] = sc.nextInt();
        }
        int c = findPlatformsByTreeMap(arr, dep, n);
        System.out.println(c);
    }

    //By Sorting
    private static int findPlatformsBySorting(int[] arr, int[] dep, int n) {
        if (n == 0 || n == 1) return n;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int c = 0, max = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (arr[i] < dep[j]) {
                c++;
                max = Math.max(max, c);
                i++;
            } else {
                c--;
                j++;
            }
        }
        return c;
    }

    //By using TreeMap
    private static int findPlatformsByTreeMap(int[] arr, int[] dep, int n) {
        if (n == 0 || n == 1) return n;
        TreeMap<Integer, Integer> h = new TreeMap<>();
        for(int i=0;i<n;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
            h.put(dep[i],h.getOrDefault(dep[i],0)-1);
        }
        int c = 0, max = 0;
        for(Map.Entry<Integer, Integer> a: h.entrySet()){
            c = c+a.getValue();
            max = Math.max(c,max);
        }
        return max;
    }
}
