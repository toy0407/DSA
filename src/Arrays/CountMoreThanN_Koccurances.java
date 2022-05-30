package Arrays;

import java.util.*;

public class CountMoreThanN_Koccurances {
    public int countOccurence(int[] arr, int n, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (h.containsKey(arr[i])) h.put(arr[i], h.get(arr[i]) + 1);
            else h.put(arr[i], 1);
        }
        int count = 0;
        for (Integer i : h.keySet()) {
            if (h.get(i) > n / k) count++;
        }

        return count;
    }
}
