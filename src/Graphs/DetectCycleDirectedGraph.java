package Graphs;
import java.util.*;

public class DetectCycleDirectedGraph {
    //BFS
    //Can be achieved by Kahn's algorithm (indegree concept). Topo Sort is only possible if a graph is Directed & Acyclic. We find the topo sort & if count of elements!=no. of nodes of graph then it is cyclic.
    //https://www.youtube.com/watch?v=V6GxfKDyLBM&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=16
    public boolean isCyclicBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] res=new int[V];
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(Integer it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            Integer node=q.poll();
            c++;
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return !(c==V);
    }
    //Can be achieved by using 2 visited arrays. One keeps account of the visited nodes overall and the other keeps account the visited nodes in a single dfs branch.
    public boolean isCyclicDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis=new boolean[V];
        boolean[] dfsvis=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(dfs(adj, i, vis, dfsvis)) return true;
            }
        }
        return false;

    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, boolean[] dfsvis){
        vis[i]=true;
        dfsvis[i]=true;
        for(Integer it:adj.get(i)){
            if(dfsvis[it]==true) return true;
            if(vis[it]==false){
                if(dfs(adj,it,vis,dfsvis)){
                    return true;
                }
            }
        }
        dfsvis[i]=false;
        return false;
    }
}
