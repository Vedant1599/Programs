package graph;

import java.util.ArrayList;
import java.util.Collections;

public class krushkal {
    static class Edge implements Comparable<Edge>{
        int src, dest, weight;
        Edge(int src, int dest, int weight){
            this.src = src; this.dest = dest; this.weight = weight;
        }

        public int compareTo(Edge edge2){
            return this.weight - edge2.weight;
        }
    }

    public static ArrayList<Edge> minTreeG(int v, int[][] adj){
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(adj[i][j]!=0){
                    edges.add(new Edge(i, j, adj[i][j]));
                }
            }
        }

        DisjointSet ds = new DisjointSet(7);
        Collections.sort(edges);
        ArrayList<Edge> ans = new ArrayList<>();

        for(int i=0; i<edges.size(); i++){
            Edge e = edges.get(i);
            int s = e.src;
            int d = e.dest;
            int wt = e.weight;
            if(ds.findUPar(s)!=ds.findUPar(d)){
                ds.unionByRank(s,d);
                ans.add(e);
            }
        }

        return ans;
    }

    public static int minTree(int v, int[][] adj){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(adj[i][j]!=0){
                    edges.add(new Edge(i,j,adj[i][j]));
                }
            }
        }

        DisjointSet ds = new DisjointSet(v);
        Collections.sort(edges);
        int minw = 0;

        for(int i=0; i<edges.size(); i++){
            Edge e = edges.get(i);

            int s = e.src;
            int d = e.dest;
            int wt = e.weight;

            if(ds.findUPar(s)!=ds.findUPar(d)){
                minw += wt;
                ds.unionByRank(s,d);
            }
        }

        return minw;
    }

    public static void main(String[] args) {
        int[][] adj = {{0, 28, 0, 0, 0, 10, 0}, {28, 0, 16, 0, 0, 0, 14}, {0, 16, 0, 12, 0, 0, 0},
                       {0, 0, 12, 0, 22, 0, 10}, {0, 0, 0, 22, 0, 25, 24}, {10, 0, 0, 0, 25, 0, 0},
                       {0, 14, 0, 10, 24, 0, 0}};

        System.out.println(minTree(7, adj));

        ArrayList<Edge> ans = minTreeG(7, adj);

        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i).src+1 +"---"+ (ans.get(i).dest+1));
        }
    }
}
