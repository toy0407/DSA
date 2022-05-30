package Arrays;

import java.util.*;

public class LongestConsecutiveSubsequence {
    static int findLongestConseqSubseq(int arr[], int n) {
        // add your code here
        SortedSet<Integer> h = new TreeSet<>();
        for (Integer i : arr) h.add(i);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(h);

        int count = 1, max = 1;
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) == arrayList.get(i - 1) + 1) {
                count++;
                max = Math.max(max, count);
            } else count = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findLongestConseqSubseq(arr, n));
    }
}
