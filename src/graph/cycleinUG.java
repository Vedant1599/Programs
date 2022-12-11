package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cycleinUG {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<7; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(5);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(6);
        adj.get(3).add(6);
        adj.get(4).add(2);
        adj.get(4).add(7);
        adj.get(5).add(3);
        adj.get(5).add(3);
        adj.get(6).add(5);

        System.out.println(isCycle(6, adj));
        System.out.println(isCycled(8, adj));


    }


    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first; this.second = second;
        }
    }

    // bfs
    public static boolean checkForCycles(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while(!q.isEmpty()){
            int parent = q.peek().second;
            int node = q.peek().first;

            for(int adjacentNode : adj.get(node)){
                if(vis[adjacentNode]==false){
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, node));
                }else if(parent!=adjacentNode) return true;
            }
        }
        return false;

    }

    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];
        for(int i=0; i<v; i++) vis[i] = false;
        for(int i=0; i<v; i++){
            if(!vis[i]){
                if(checkForCycles(i, v, adj, vis)) return true;
            }
        }
        return false;
    }


    //dfs
    public static boolean isCycled(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];
        for(int i=0; i<v; i++) vis[i] = false;
        for(int i=0; i<v; i++){
            if(!vis[i]){
                if(dfs(i, -1, v, adj, vis)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(int adjacentNode : adj.get(node)){
            if(!vis[adjacentNode]){
                if(dfs(adjacentNode, node, v, adj, vis)) return true;
            }else{
                if(adjacentNode==parent) return true;
            }
        }
        return false;
    }
}
