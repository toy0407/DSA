package DynamicProgramming;

class EggDropping {
    Integer[][] dp;
    public int superEggDrop(int K, int N) {
        dp = new Integer[K + 1][N + 1];
        return helper(K, N);
    }
    private int helper(int egg, int N) {
        if (N <= 1) return N;
        if (egg == 1) return N;
        if (dp[egg][N] != null) return dp[egg][N];
        int low = 1, high = N, result = N;
        while (low < high) {
            int k = low + (high - low) / 2;
            int left = helper(egg - 1, k - 1);
            int right = helper(egg, N - k);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left == right) {
                break;
            } else if (left < right) {
                low = k + 1;
            } else {
                high = k;
            }
        }
        return dp[egg][N] = result;
    }
}
