package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class dijP {
    static class Pair{
        int first,second;

        Pair(int x, int y){
            this.first = x; this.second = y;
        }
    }

    public static void main(String[] args) {
        int[][] adj = {{0, 4, 4, 0, 0, 0}, {4, 0, 2, 0, 0, 0}, {4, 2, 0, 3, 1, 6},
                {0, 0, 3, 0, 0, 2}, {0, 0, 1, 0, 0, 3}, {0, 0, 6, 2, 3, 0}};

        int[] wt = min(adj, 6, 0);

        for(int i=0; i<wt.length; i++){
            System.out.print(wt[i] +" ");
        }
    }

    public static int[] min(int[][] adj, int l, int s){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.second-y.second);

//        Queue<Pair> pq = new LinkedList<>();
        int[] ans = new int[l];
        int[] vis = new int[l];

        Arrays.fill(ans, (int) 1e8);
        ans[s] = 0;
        pq.add(new Pair(s, 0));
        vis[s] = 1;

        while(!pq.isEmpty()){
            int v = pq.peek().first;
            int wt = pq.poll().second;

            for(int i=0; i<l; i++){
                if(adj[v][i]!=0){
                    int edge_wt = adj[v][i];

                    if(ans[v]+edge_wt<ans[i]){
                        ans[i] = edge_wt + ans[v];
                        pq.add(new Pair(i, ans[i]));
                    }
                }
            }
        }

        return ans;
    }
}
