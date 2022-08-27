package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class PrimsAlgorithm {

    static class Node implements Comparator<Node> {
        int val, weight;
        Node() {
        }
        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
        @Override
        public int compare(Node o1, Node o2) {
            return o1.weight - o2.weight;
        }
    }
    /**
     * Prims Algorithm
     * Minimum Spanning Tree
     * https://www.youtube.com/watch?v=HnD676J56ak&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=20
     * https://takeuforward.org/data-structure/minimum-spanning-tree-mst-using-prims-algo/
     * TC: O(NlogN). N iterations and logN for priority queue
     * SC: O(N). Three arrays and priority queue
     */
    static void primsAlgrithm(int V, ArrayList<ArrayList<Node>> adj) {
        int[] dist=new int[V];
        boolean[] mst=new boolean[V];
        int[] parent=new int[V];

        Arrays.fill(dist,(int)1e9);
        Arrays.fill(parent,-1);

        dist[0]=0;

        PriorityQueue<Node> pq=new PriorityQueue<>(V, new Node());
        pq.add(new Node(0,dist[0]));
        for(int i=0;i<V-1;i++){
            int u=pq.poll().val;
            mst[u]=true;

            for(Node it:adj.get(u)){
                if(mst[it.val]==false && it.weight<dist[it.val]){
                    dist[it.val]=it.weight;
                    parent[it.val]=u;
                    pq.add(new Node(it.val,dist[it.val]));
                }
            }

        }
        int mstSum=0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i]+" - "+i);
            mstSum+=dist[i];
        }
        System.out.println(mstSum);
    }



    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));
        primsAlgrithm(n,adj);

    }
}
