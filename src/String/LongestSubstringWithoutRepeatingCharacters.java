package String;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int count=0,max=0;
        if(n==0 || n==1) return n;
        HashSet<Character> h=new HashSet();
        int l=0,r=0;
        while(r<n){
            if(h.contains(s.charAt(r))){
                while(s.charAt(l)!=s.charAt(r)){
                    h.remove(s.charAt(l));
                    l++;
                }
                l++;
                count=r-l+1;

            }
            else{
                h.add(s.charAt(r));
                count++;
                max=Math.max(max,count);
            }
            r++;
        }
        return max;

    }
}
