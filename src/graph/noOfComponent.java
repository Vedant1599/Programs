package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class noOfComponent {

    static class pair{
        int me;
        int papa;

        pair(int me, int papa){
            this.me = me;
            this.papa = papa;
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<13; i++){
            adj.add(new ArrayList<Integer>());
        }

//        adj.get(0).add(1);
//        adj.get(0).add(2);
//        adj.get(1).add(0);
//        adj.get(1).add(2);
//        adj.get(1).add(3);
//        adj.get(1).add(4);
//        adj.get(2).add(0);
//        adj.get(2).add(1);
//        adj.get(2).add(4);
//        adj.get(2).add(6);
//        adj.get(2).add(7);
//        adj.get(3).add(1);
//        adj.get(3).add(4);
//        adj.get(4).add(1);
//        adj.get(4).add(2);
//        adj.get(4).add(3);
//        adj.get(4).add(4);
//        adj.get(5).add(4);
//        adj.get(6).add(2);
//        adj.get(6).add(7);
//        adj.get(7).add(2);
//        adj.get(7).add(6);
//
//        adj.get(8).add(9);
//        adj.get(9).add(8);
//
//        adj.get(10).add(11);
//        adj.get(11).add(10);
//        adj.get(11).add(12);
//        adj.get(12).add(11);

        adj.get(0).add(1);
        adj.get(1).add(0);

        System.out.println(numComponent(adj));
    }
    public static void isCycle(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
        int n = adj.size();

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
//                int me = q.peek().me;
//                int papa = q.poll().papa;
                int me = q.poll();
                vis[me] = 1;
                for(int adjNode : adj.get(me)){
                    if(vis[adjNode]==0){
                        q.add(adjNode);
                    }
                }
        }
    }

    public static void bsf(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 1;

        while(!q.isEmpty()){
            int me = q.poll();
            vis[me] = 1;
            for(int adjNode : adj.get(me)){
                if(vis[adjNode]==0){
                    q.add(adjNode);
                }
            }
        }
    }

    public static int numComponent(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        int cnt = 0;
        int[] vis = new int[adj.size()];

        for(int i=0; i<n; i++){
            if(vis[i]==0){
                bsf(adj, vis, i);
                cnt++;
            }
        }

        return cnt;
    }
}
