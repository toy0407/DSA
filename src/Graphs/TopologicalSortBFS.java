package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
    /**
     * BFS
     * Topological sort using BFS is achieved by Kahn's Algorithm.
     * https://www.youtube.com/watch?v=rZv_jHZva34&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=14&t=901s
     */
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
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
            res[c++]=node;
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return res;

    }
}
