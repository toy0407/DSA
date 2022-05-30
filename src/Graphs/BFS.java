package Graphs;

import java.util.*;

public class BFS {
    static class Solution {
        // Function to return Breadth First Traversal of given graph. Taking all disconnected components in consideration
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            ArrayList<Integer> ans = new ArrayList<>();

            boolean[] vis = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    bfs(vis, i, adj, ans);
                }
            }
            return ans;
        }

        void bfs(boolean[] vis, int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
            vis[i] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                Integer node = q.peek();
                q.remove();
                ans.add(node);
                for (Integer j : adj.get(node)) {
                    if (!vis[j]) {
                        vis[j] = true;
                        q.add(j);
                    }
                }
            }
        }
    }
}
