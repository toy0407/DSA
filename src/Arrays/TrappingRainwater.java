package Arrays;

public class TrappingRainwater {
    static long trappingWater(int height[], int n) {
        int i;
        long[] maxR = new long[n];
        long[] maxL = new long[n];
        long max = Long.MIN_VALUE;
        for (i = 0; i < n; i++) {
            if (height[i] >= max) max = height[i];
            maxL[i] = max;
        }
        max = Long.MIN_VALUE;
        for (i = n - 1; i >= 0; i--) {
            if (height[i] >= max) max = height[i];
            maxR[i] = max;
        }
        long s = 0;
        for (i = 0; i < n; i++) {
            s += Math.min(maxL[i], maxR[i]) - height[i];
        }
        return s;
    }
}
