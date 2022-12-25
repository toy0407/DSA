package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://www.youtube.com/watch?v=CrxG4WJotgg&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw

public class ShortestPathWeightedDirectedAcyclicGraph {
    class Pair {
        int val, weight;

        Pair(int val, int dist) {
            this.val = val;
            this.weight = dist;
        }
    }

    Stack<Integer> st = new Stack<>();

    void getShortestPath(int V, ArrayList<ArrayList<Pair>> adj, int src) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) getTopoSort(i, adj, vis);
        }
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for (Pair it : adj.get(node)) {
                if (dist[node] + it.weight < dist[it.val]) {
                    dist[it.val] = dist[node] + it.weight;
                }
            }

        }
        for (Integer i : dist) {
            System.out.println(i);
        }

    }

    private void getTopoSort(int i, ArrayList<ArrayList<Pair>> adj, boolean[] vis) {
        vis[i] = true;
        for (Pair it : adj.get(i)) {
            getTopoSort(it.val, adj, vis);
        }
        st.push(i);
    }


}
