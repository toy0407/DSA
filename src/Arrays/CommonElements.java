package Arrays;

import java.util.*;

public class CommonElements {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> res1 = compareArray(A, B);
        int[] res = new int[res1.size()];
        for (int i = 0; i < res1.size(); i++) {
            res[i] = res1.get(i);
        }
        ArrayList<Integer> res2 = compareArray(res, C);
        return res2;
    }


    ArrayList<Integer> compareArray(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);

        ArrayList<Integer> ans = new ArrayList<>();
        int n = a1.length;
        int m = a2.length;
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (a1[i] == a2[j]) {
                if (ans.contains(a1[i])) ans.add(a1[i]);
                i++;
                j++;
            } else if (a1[i] > a2[j]) j++;
            else i++;
        }
        return ans;
    }
}
