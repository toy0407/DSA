package Graphs;

import java.util.ArrayList;

public class DFS {
    ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs(adj, i, vis);
            }
        }
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
        ans.add(i);
        vis[i] = true;
        for (Integer j : adj.get(i)) {
            if (vis[j] == false) {
                vis[j] = true;
                dfs(adj, j, vis);
            }
        }
    }
}
