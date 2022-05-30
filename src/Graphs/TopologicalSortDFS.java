package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    // DFS traversal of the graph with storing each traversed elements in a stack gives a topo sort of the graph in reverse order.
    // Pop the elements of the stack into a array to obtain the required topo sort.
    boolean[] vis;
    Stack<Integer> ans=new Stack<>();
    //Function to return list containing vertices in Topological order.
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
        int[] res=new int[V];
        int c=0;
        while(!ans.isEmpty()){
            res[c++]=ans.pop();
        }
        return res;
    }

    void dfs(int i,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[i]=true;
        for(Integer it:adj.get(i)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
        ans.push(i);
    }
}
