package Graphs;

import java.util.Scanner;

/**
 * Disjoint Set Union and Path Compression
 * https://www.youtube.com/watch?v=3gbO7FDYNFQ&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=23
 * TC: O(4a). Mathematically proven,
 * SC: O(N). Rank and Parent matrix.
 */
public class DisjointSet {
    static int[] parent = new int[100000];
    static int[] rank = new int[100000];

    //Make every element parent of itself.
    static void makeSet(int n) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    //Find parent of a given node and perform path compression.
    static int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]); //Path compression is taking place
    }

    static void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);
        if (u != v) {
            if (rank[u] < rank[v]) parent[u] = v;
            else if (rank[u] > rank[v]) parent[v] = u;
            else {
                parent[v] = u;
                rank[u]++;//Update rank of the parent only when both the ranks are equal.
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        makeSet(n);
        while (n-- > 0) {
            int u = sc.nextInt(), v = sc.nextInt();
            union(u, v);
        }
        int p = sc.nextInt(), q = sc.nextInt();
        //If they belong to same parent
        if (findParent(p) == findParent(q)) System.out.println("Same Component");
        else System.out.println("Different Component");
    }
}
