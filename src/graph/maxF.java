package graph;

import java.util.LinkedList;
import java.util.Queue;

public class maxF {

    public static void main(String[] args) {
        int[][] adj = {
                { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
                { 0, 4, 0, 0, 14, 0 },  { 0, 0, 9, 0, 0, 20 },
                { 0, 0, 0, 7, 0, 4 },   { 0, 0, 0, 0, 0, 0 }
        };

        System.out.println(fordF(adj, 0, 5));
    }

    public static int fordF(int[][] adj, int s, int t){
        int l = adj.length;

        int[][] fl = adj;

        int[] parent = new int[l];

        int maxFlow = 0;

        while (bfs(fl, s, t, parent)){
            int path_flow = Integer.MAX_VALUE;
            for(int i=t; i!=s; i = parent[i]){
                int node = parent[i];
                path_flow = Math.min(path_flow, fl[node][i]);
            }

            for(int i=t; i!=s; i++){
                int node = parent[i];
                fl[node][i] -= path_flow;
                fl[i][node] += path_flow;
            }

            maxFlow += path_flow;

        }

        return maxFlow;

    }

    public static boolean bfs(int[][] fl, int s, int t, int parent[]){

        int[] vis = new int[fl.length];

        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        vis[s] = 1;
        parent[s] = -1;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i=0; i<fl.length; i++){
                if(vis[i]==0 && fl[node][i]>0){
                    if(i==t){
                        parent[i] = node;
                        return true;
                    }
                    q.add(i);
                    parent[i] = node;
                    vis[i] = 1;
                }
            }
        }

        return false;
    }
}
