import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] strAr1=new String[] {"P->O", "O->R", "R->T","T->U"};

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        for(String a:strAr1){
            char u = a.charAt(0);
            char v = a.charAt(3);
            adj.get(u-'A').add(v-'A');
        }

        boolean[] vis = new boolean[26];
        for(int i=0;i<adj.size();i++){
            if(vis[i]!=true && adj.get(i).size()!=0){
                dfs(adj,vis,i);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(st.size()>0){
            ans.append((char)(st.pop()+'A'));
        }
        System.out.println(ans.toString());
    }

    static Stack<Integer> st = new Stack<>();
    static void dfs(List<List<Integer>> adj, boolean[] vis, int i){
        vis[i] = true;
        for(Integer j:adj.get(i)){
            if(vis[j]!=true){
                dfs(adj,vis,j);
            }
        }
        st.push(i);

    }
}