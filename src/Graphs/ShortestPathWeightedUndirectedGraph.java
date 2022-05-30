package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Dijkstra's Algorithm
 * Find the shortest path in Weighted Undirected Graph.
 * https://www.youtube.com/watch?v=jbhuqIASjoM&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=18&t=732s
 * https://takeuforward.org/data-structure/dijkstras-algorithm-shortest-distance/
 * TC: O((N+E)*logN). Going through N nodes and E edges and log N for priority queue
 * SC: O(N). Distance array and priortyQueue
 */
public class ShortestPathWeightedUndirectedGraph {
    static class Node implements Comparator<Node> {
        int value,weight;
        Node(){};
        Node(int value,int weight){
            this.weight=weight;
            this.value=value;
        }
        @Override
        public int compare(Node o1, Node o2) {
            return o1.weight-o2.weight;
        }
    }

    static void shortestPath(int src, ArrayList<ArrayList<Node>> adj, int V){
        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>(V,new Node());
        pq.add(new Node(src,0));
        while(pq.size()>0){
            Node node=pq.poll();
            for (Node it: adj.get(node.value)){
                if(dist[node.value]+it.weight<dist[it.value]){
                    dist[it.value]=dist[node.value]+it.weight;
                    pq.add(new Node(it.value,dist[it.value]));
                }
            }
        }
        for (Integer it:dist){
            System.out.println(it);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        shortestPath(0, adj, n);
    }

}
