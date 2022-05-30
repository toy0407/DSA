package String;

import java.util.HashMap;
import java.util.Scanner;

public class CheckStringValidShuffleOfTwoStrings {

    static boolean check(String s1, String s2, String res) {
        if (s1.length() + s2.length() != res.length()) return false;

        HashMap<Character, Integer> h = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            if (h.containsKey(c)) h.put(c, h.get(c) + 1);
            else h.put(c, 1);
        }
        for (Character c : s2.toCharArray()) {
            if (h.containsKey(c)) h.put(c, h.get(c) + 1);
            else h.put(c, 1);
        }

        for (Character c : res.toCharArray()) {
            if (h.containsKey(c)){
                if (h.get(c)>1) h.put(c,h.get(c)-1);
                else h.remove(c);
            }
            else return false;
        }

        if(h.isEmpty()) return true;
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        System.out.println(check(s1, s2, s3));
    }

}
