package Graphs;

import java.util.*;

/**
 * Bellman-Ford Algorithm
 * Find shortest path with negative edge/ Find negative cycles in graph
 * Works only on Directed graphs with both positive and negative weights (Except negative cycles).
 * For Undirected graphs, we need to first convert undirected graph into directed graph.
 * https://www.youtube.com/watch?v=75yC1vbS8S8&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=28
 * https://takeuforward.org/data-structure/bellman-ford-algorithm-shortest-distance-with-negative-edge/
 * TC: O(N*E). We check E edges N times
 * SC: O(N). Distance Array
 */
public class ShortestPathWithNegativeEdge {


    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src] = 0;
        //Relax the edges V-1 times as it is the max number of times an edge can be relaxed if it doesn't contain a negative cycle.
        for(int j = 0;j<V-1;j++){
            for(int i=0;i<edges.size();i++){
                int u = edges.get(i).get(0);
                int v = edges.get(i).get(1);
                int wt = edges.get(i).get(2);
                if(dist[u]+wt<dist[v]){ // This step is called edge relaxation.
                    dist[v] = dist[u]+wt;
                }
            }
        }

        //Check for negative cycle by relaxing the edges for the Vth time. If relaxation is possible, there's a negative cycle.
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int wt = edges.get(i).get(2);
            if(dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }

        return dist;
    }
}
