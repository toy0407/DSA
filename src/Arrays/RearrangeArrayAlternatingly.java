package Arrays;

public class RearrangeArrayAlternatingly {
    /*
    Here the sum is done for even and odd numbers.
    Same concept applies for positive and negative numbers.
     */

    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                swap(nums, i, j);
                j++;
            }
        }
        return nums;
    }

    void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
}
