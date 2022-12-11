package graph;

import java.util.PriorityQueue;

public class prims {

    static class Edge{
        int src, dest, wt;

        Edge(int src, int dest, int wt){
            this.src = src; this.dest = dest; this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int[][] adj = {{0, 28, 0, 0, 0, 10, 0}, {28, 0, 16, 0, 0, 0, 14}, {0, 16, 0, 12, 0, 0, 0},
                {0, 0, 12, 0, 22, 0, 10}, {0, 0, 0, 22, 0, 25, 24}, {10, 0, 0, 0, 25, 0, 0},
                {0, 14, 0, 10, 24, 0, 0}};

        System.out.println(minTreeP(7,adj));
    }

    static int minTreeP(int v, int[][] adj){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((x,y)-> x.wt-y.wt);

        int[] vis = new int[v];

        pq.add(new Edge(0,0,0));

        int sum =0;

        while(!pq.isEmpty()){
            Edge e = pq.remove();
            int s = e.src;
            int d = e.dest;
            int wt = e.wt;

            if(vis[d]==1) continue;

            vis[d] = 1;
            sum += wt;

            for(int i=0; i<v; i++){
                if(adj[d][i]!=0){
                    if(vis[i]==0){
                        pq.add(new Edge(d,i,adj[d][i]));
                    }
                }
            }
        }

        return sum;
    }
}
