package DynamicProgramming;

import java.util.HashMap;

public class ScrambledString {
    HashMap<String,Boolean> hm=new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if(s1.compareTo(s2)==0) return true;
        if(s1.length()<=1) return false;
        String k= s1+" "+s2;
        if(hm.containsKey(k)) return hm.get(k);
        int n=s1.length();
        boolean flag=false;
        for(int i=1;i<s1.length();i++){
            boolean cond1 = isScramble(s1.substring(0,i),s2.substring(n-i,n)) && isScramble(s1.substring(i,n),s2.substring(0,n-i));  //swap
            boolean cond2 = isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i,n),s2.substring(i,n));  //not-swap
            if(cond1||cond2) {
                flag=true;
                break;
            }
        }
        hm.put(k,flag);
        return flag;
    }

}
