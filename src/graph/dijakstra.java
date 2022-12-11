package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class dijakstra {
    static class Edge{
        int src, dest, weight;

        Edge(int src, int dest, int weight){
            this.src=src; this.dest=dest; this.weight=weight;
        }
    }

    public static void main(String[] args) {
        int[][] adj = {{0, 4, 4, 0, 0, 0}, {4, 0, 2, 0, 0, 0}, {4, 2, 0, 3, 1, 6},
                       {0, 0, 3, 0, 0, 2}, {0, 0, 1, 0, 0, 3}, {0, 0, 6, 2, 3, 0}};

        int[] wt = dij(6, 0, adj);

        for(int i=0; i<wt.length; i++){
            System.out.print(wt[i] +" ");
        }
    }

    static int[] dij(int v, int s, int[][] adj){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((x,y)-> x.weight-y.weight);

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        pq.add(new Edge(0,s,0));

        while(!pq.isEmpty()){
            Edge e = pq.remove();
            int dis = e.dest;

            for(int i=0; i<v; i++){
                if(adj[dis][i]!=0){
                    int edwt = adj[dis][i];

                    if(dist[dis] + edwt < dist[i]){
                        dist[i] = dist[dis]+edwt;
                        pq.add(new Edge(dis, i, dist[i]));
                    }
                }
            }
        }
        return dist;
    }
}
