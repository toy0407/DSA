package Graphs;

import java.util.*;

public class PrintShortesPathDjikstra {
    static class Pair{
        int val, dist;
        Pair(int val, int dist){
            this.val = val;
            this.dist = dist;
        }

    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        int[] parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i]=i;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair o1, Pair o2){
                return o1.dist-o2.dist;
            }
        });
        pq.add(new Pair(1,0));
        dist[1] = 0;
        while(pq.size()>0){
            Pair node = pq.remove();
            for(Pair it: adj.get(node.val)){
                if(dist[node.val] + it.dist < dist[it.val]){
                    dist[it.val] = dist[node.val] + it.dist;
                    pq.add(new Pair(it.val, dist[it.val]));
                    parent[it.val] = node.val;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(dist[n]==(int)1e9){
            ans.add(-1);
            return ans;
        }
        int i = n;
        while(parent[i]!=i){
            ans.add(i);
            i = parent[i];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}
