package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckForBipartite {
    //Check if graph nodes can be coloured with alternate colors.Possible in every case except odd number of nodes in cycle.
    //Formally, A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
    int[] colors;
    public boolean isBipartite(List<List<Integer>> graph) {
        int V=graph.size();
        colors=new int[V];
        for(int i=0;i<V;i++)
            colors[i]=-1;
        for(int i=0;i<V;i++){
            if(colors[i]==-1){
                if(checkBFS(i,graph)) return false;
            }
        }
        return true;
    }

    boolean checkBFS(int i,List<List<Integer>> graph){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        colors[i]=1;
        while(!q.isEmpty()){
            Integer node=q.remove();
            for(Integer it: graph.get(node)){
                if(colors[it]==-1){
                    colors[it]=1-colors[node];
                    q.add(it);
                }
                else if(colors[it]==colors[node]) return true;
            }
        }
        return false;
    }
}
