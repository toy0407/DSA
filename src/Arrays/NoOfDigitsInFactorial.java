package Arrays;

public class NoOfDigitsInFactorial {
    static int findDigits(int n) {
        // factorial exists only for n>=0
        if (n < 0)
            return 0;

        // base case
        if (n <= 1)
            return 1;

        // else iterate through n and calculate the
        // value
        double digits = 0;
        for (int i = 2; i <= n; i++)
            digits += Math.log10(i);

        return (int) (Math.floor(digits)) + 1;
    }
}
