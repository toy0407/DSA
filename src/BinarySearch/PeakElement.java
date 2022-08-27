package BinarySearch;

import java.util.Scanner;

public class PeakElement {

    static int peak(long[] ar, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (ar[mid] > ar[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] ar = new long[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        System.out.println(peak(ar, n));
    }
}
