package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Kruskal Algorithm
 * Minimum Spanning Tree using Kruskal Algorithm
 * https://www.youtube.com/watch?v=1KRmCzBl_mQ&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=24&t=655s
 * https://takeuforward.org/data-structure/minimum-spanning-tree-mst-using-kruskals-algo/
 * TC: O(ElogE)+O(E*4*alpha), ElogE for sorting and E*4*alpha for findParent operation ‘E’ times
 * SC: O(N). Parent array+Rank Array
 */

public class KruskalAlgorithm {
    static class Node {
        int weight, u, v;


        public Node(int u, int v, int weight) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }
    }

    static void KruskalAlgorithm(ArrayList<Node> adj, int V) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        Collections.sort(adj, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        int costMst = 0;
        ArrayList<Node> mst = new ArrayList<>();
        for (Node it : adj) {
            if (getParent(it.u, parent) != getParent(it.v, parent)) {
                costMst += it.weight;
                mst.add(it);
                union(it.u, it.v, parent, rank);
            }
        }

        System.out.println(costMst);
        for (Node it : mst) {
            System.out.println(it.u + " - " + it.v);
        }

    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        u = getParent(u, parent);
        v = getParent(v, parent);
        if (u != v) {
            if (rank[u] < rank[v]) parent[u] = v;
            else if (rank[u] > rank[v]) parent[v] = u;
            else {
                parent[v] = u;
                rank[u]++;
            }
        }
    }

    private static int getParent(int u, int[] parent) {
        if (parent[u] == u) return u;
        return parent[u] = getParent(parent[u], parent);
    }

    public static void main(String args[]) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();


        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));


        KruskalAlgorithm(adj, n);

    }
}
