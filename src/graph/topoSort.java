package graph;

import java.util.ArrayList;
import java.util.Stack;

public class topoSort {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<6; i++) adj.add(new ArrayList<Integer>());

        addE(adj, 2, 3);
        addE(adj, 3, 1);
        addE(adj, 4, 0);
        addE(adj, 4, 1);
        addE(adj, 5, 0);
        addE(adj, 5, 2);

        int[] ans = topo(adj.size(), adj);

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] +" ");
        }
    }

    public static void addE(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
    }

    public static int[] topo(int v, ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[v];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<v; i++){
            if(vis[i]==0){
                dfs(adj, st, vis, i);
            }
        }

        int l =0;
        int[] ans = new int[v];
        while(!st.isEmpty()){
            ans[l++] = st.pop();
        }

        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int[] vis, int node) {
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it]==0) dfs(adj, st, vis, it);
        }
        st.push(node);
    }
}
