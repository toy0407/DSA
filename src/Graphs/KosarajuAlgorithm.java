package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuAlgorithm {
    /**
     * Kosaraju Algorithm
     * Find all the strongly connected components
     * https://www.youtube.com/watch?v=V8qIqJxCioo&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=27&t=427s
     * https://takeuforward.org/data-structure/kosarajus-algorithm-for-strongly-connected-componentsscc/
     * TC: O(N+E), DFS+TopoSort
     * SC: O(N+E), Transposing the graph
     */

    static void kosarajuAlgorithm(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] vis=new boolean[V];
        //Performing Topological Sort
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs(i,adj,V,vis);
            }
        }
        //Reinitializing boolean array to false;
        Arrays.fill(vis,false);
        //Creating the transpose array
        ArrayList<ArrayList<Integer>> adjTranspose=new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjTranspose.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for (Integer it: adj.get(i)){
                adjTranspose.get(it).add(i);
            }
        }
        //Performing dfs over transpose array by popping elements from the stack
        while(stack.size()>0){
            Integer node=stack.pop();
            if(!vis[node]){
                revDFS(node,adjTranspose,V,vis);
                System.out.println();
            }
        }

    }

    //DFS of the transpose array
    private static void revDFS(Integer i, ArrayList<ArrayList<Integer>> adjTranspose, int v, boolean[] vis) {
        vis[i]=true;
        System.out.print(i+" ");
        for(Integer it:adjTranspose.get(i)){
            if (!vis[it]) revDFS(it,adjTranspose,v,vis);
        }
    }

    //Topological Sort DFS
    static Stack<Integer> stack=new Stack<>();
    private static void dfs(int i,ArrayList<ArrayList<Integer>> adj, int v, boolean[] vis) {
        vis[i]=true;
        for(Integer it:adj.get(i)){
            if(!vis[it]){
                dfs(it,adj,v,vis);
            }
        }
        stack.push(i);
    }

    public static void main(String args[])
    {
        int n = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(3).add(2);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(4);
        adj.get(6).add(5);

        kosarajuAlgorithm(adj,n);


    }
}
