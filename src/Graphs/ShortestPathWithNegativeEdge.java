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
    class Node {
        int weight, u, v;
        public Node(int u, int v, int weight) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }
    }

    void shortestPath(int src, ArrayList<Node> adj, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        //We iterate N-1 times since it is the max possible relaxation that can happen if the graph doesn't have negative cycle.
        for (int i = 0; i < V - 1; i++) {
            for (Node it : adj) {
                if (dist[it.u] + it.weight < dist[it.v]) {
                    dist[it.v] = dist[it.u] + it.weight;
                }
            }
        }
        boolean hasNegativeCycle = false;
        for (Node it : adj) {
            if (dist[it.u] + it.weight < dist[it.v]) {
                hasNegativeCycle = true;
                break;
            }
        }
        if (!hasNegativeCycle) for (Integer i : dist) System.out.println(i);
    }
}
