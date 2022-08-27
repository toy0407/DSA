package BinarySearch;

import java.util.Scanner;

public class SearchingWhereAdjacentDifferByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int k = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        System.out.println(search(ar, n, target, k));

    }

    static int search(int[] ar, int n, int target, int k) {
        for (int i = 0; i < n; i++) {
            if (ar[i] == target) {
                if (i == 0 ){
                    if(Math.abs(ar[i] - ar[i + 1]) >= k || Math.abs(ar[i] - ar[n-1]) >= k)  return i;
                }
                else if (i == n - 1 ){
                    if (Math.abs(ar[i] - ar[i - 1]) >= k || Math.abs(ar[i] - ar[0]) >= k) return i;
                }
                else if (Math.abs(ar[i] - ar[i + 1]) >= k || Math.abs(ar[i] - ar[i - 1]) >= k) return i;
            }
        }
        return -1;
    }
}
