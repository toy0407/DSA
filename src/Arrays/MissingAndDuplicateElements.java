package Arrays;

import java.util.Scanner;

public class MissingAndDuplicateElements {
    /**
     * Missing and Duplicate Elements
     * Use Swap sort in these cases
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        int i = 0;
        while (i < n) {
            if (ar[i] == i + 1) i++;
            else {
                if (ar[i] == ar[ar[i] - 1]) {
                    i++;
                    continue;
                } else swap(ar, i, ar[i] - 1);
            }
        }
        for (i = 0; i < n; i++) {
            if (ar[i] != i + 1) {
                System.out.println("Missing Number " + (i + 1));
                System.out.println("Duplicate Number " + ar[i]);
            }
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

}
