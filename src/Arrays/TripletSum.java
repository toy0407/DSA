package Arrays;

import java.util.*;

public class TripletSum {

    public static boolean find3Numbers(int A[], int n, int X) {

        // Your code Here
        Arrays.sort(A);
        for (int i = 0; i < n - 1; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (A[l] + A[r] + A[i] == X) return true;
                else if (A[l] + A[r] + A[i] < X) l++;
                else r--;
            }
        }
        return false;
    }
}
