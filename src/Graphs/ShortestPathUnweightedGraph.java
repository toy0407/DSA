package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweightedGraph {
    //BFS
    //https://www.youtube.com/watch?v=hwCWi7-bRfI&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=16
    void shortestPath(ArrayList<ArrayList<Integer>> adj,int V,int src){
        int[] dist= new int[V];
        Arrays.fill(dist,(int)1e9);
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        dist[src]=0;
        while (!q.isEmpty()){
            Integer node= q.poll();
            for (Integer it:adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it]=dist[node]+1;
                    q.add(it); // To only visit nodes which were not visited previously
                }
            }
        }

        for (int i=0;i<V;i++){
            System.out.println(dist[i]);
        }
    }
}
