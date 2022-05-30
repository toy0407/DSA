package String;

import java.util.Scanner;

public class StringsRotationOfEachOther {

    static boolean isRotation(String str1, String str2){
        if(str1.length()==str2.length() && (str1+str1).contains(str2)) return true;
        return false;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(isRotation(s1,s2));
    }

}
