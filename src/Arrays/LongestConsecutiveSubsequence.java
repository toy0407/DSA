package Arrays;

import java.util.*;

public class LongestConsecutiveSubsequence {

    //Time Complexity: O(N)
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1) return n;
        Set<Integer> h=new HashSet<>();
        for(Integer num:nums){
            h.add(num);
        }
        int max=0,c=0;
        for(Integer num: nums){
            if(!h.contains(num - 1)){
                int curr=num;
                c=1;
                while(h.contains(num+1)){
                    c++;
                    num++;
                }
            }
            max=Math.max(c,max);
        }
        return max;
    }

    //Time Complexity: O(NlogN)
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
