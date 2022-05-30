package Arrays;

import java.util.*;

public class CountPairsWithGivenSum {

    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (h.containsKey(arr[i]) == false) h.put(arr[i], 0);
            h.put(arr[i], h.get(arr[i]) + 1);
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (h.containsKey(k - arr[i])) {
                c += h.get(k - arr[i]);
                if (arr[i] == k - arr[i]) c--;
            }
        }
        return c / 2;
    }
}
