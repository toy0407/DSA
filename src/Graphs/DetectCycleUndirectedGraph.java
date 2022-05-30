package Graphs;

import java.util.*;

public class DetectCycleUndirectedGraph {

    class Node {
        int val;
        int prev;

        Node(int val, int prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (bfs(adj, i, vis)) return true;
            }
        }
        return false;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, -1));
        vis[i] = true;

        while (!q.isEmpty()) {
            Integer node = q.peek().val;
            int prev = q.peek().prev;
            q.remove();
            for (Integer j : adj.get(node)) {

                if (vis[j] == false) {

                    q.add(new Node(j, node));
                    vis[j] = true;
                } else if (prev != j) return true;
            }
        }
        return false;

    }
}
