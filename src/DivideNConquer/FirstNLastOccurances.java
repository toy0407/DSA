package DivideNConquer;

import java.util.*;

public class FirstNLastOccurances {
    static int firstOccurance(long[] ar, int n, int x) {
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] == x) {
                ans = mid;
                r = mid - 1;
            } else if (ar[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return ans;
    }

    static int lastOccurance(long[] ar, int n, int x) {
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] == x) {
                ans = mid;
                l = mid + 1;
            } else if (ar[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] ar = new long[n];
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();
        int x = sc.nextInt();
        System.out.println(firstOccurance(ar, n, x));
    }
}
