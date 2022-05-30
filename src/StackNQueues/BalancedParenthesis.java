package StackNQueues;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        boolean ans=checkForCalancedParenthesis(s);
        System.out.println(ans);
    }

    private static boolean checkForCalancedParenthesis(String s) {
        if (s.length()%2!=0) return false;
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            char r=s.charAt(i);
            if (r=='(' || r=='[' || r=='{' ) stack.push(r);
            else {
                if (r==')' && stack.empty()==false && stack.peek()=='(') stack.pop();
                else if (r==']'  && stack.empty()==false && stack.peek()=='[') stack.pop();
                else if (r=='}'  && stack.empty()==false && stack.peek()=='{') stack.pop();
                else return false;
            }
        }
        if (stack.empty()) return true;
        return false;
    }
}
