package String;

import java.io.IOException;
import java.util.Scanner;

public class KMPAlgorithm {

    static int[] lps;

    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();

        System.out.println(search(s1,s2));
    }

    private static int search(String text, String pattern) {
        lps = new int[pattern.length()+1];
        computeLPS(pattern);
        int j=0,i=0;
        while (i<text.length()){
            if (text.charAt(i)==pattern.charAt(j)){
                i++;j++;
            }
            if (j==pattern.length()) {
                return i-j;
            }
            else if (i<text.length() && text.charAt(i)!=pattern.charAt(j)){
                if (j!=0) j=lps[j-1];
                else i++;
            }
        }
        return -1;
    }

    private static void computeLPS(String s2) {
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < s2.length()) {
            if (s2.charAt(i) == s2.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
