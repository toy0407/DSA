package String;

import java.util.Scanner;

public class StringHashing {
    static long[] dp = new long[100001];
    static long[] inv = new long[100001];
    static long p = 41;
    static int m = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(strStr(s1, s2));

    }

    static int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() != 0) return -1;
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        inithay(haystack);
        long subval = initneedle(needle);
        int k = needle.length();
        for (int i = 1; i <= haystack.length() - k + 1; i++) {
            long r = ((dp[i + k - 1] - dp[i - 1]) * inv[i]) % m;
            if ((r) == subval)
                return i - 1;
        }
        return -1;
    }

    static void inithay(String haystack) {
        dp[1] = haystack.charAt(0) - 'a' + 1;
        inv[1] = 1;
        long p_power = 1;
        for (int i = 1; i < haystack.length(); i++) {
            p_power = (p_power * p) % m;
            inv[i + 1] = power(p_power, m - 2) % m;
            dp[i + 1] = (dp[i] + (haystack.charAt(i) - 'a' + 1) * p_power) % m;
        }
    }

    static long initneedle(String needle) {

        long sum = 0;
        for (int i = 0; i < needle.length(); i++) {
            sum = (sum + (power(p, i) * (needle.charAt(i) - 'a' + 1))) % m;
        }
        return sum;
    }

    static long power(long x, long y) {
        long res = 1; // Initialize result

        x = x % m; // Update x if it is more than or
        // equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0) {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % m;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % m;
        }
        return res;
    }

}

