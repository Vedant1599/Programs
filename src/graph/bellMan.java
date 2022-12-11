package graph;

import java.util.ArrayList;

public class bellMan {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        addE(adj, 0, 1, 5);
        addE(adj, 1, 2, -2);
        addE(adj, 1, 5, -3);
        addE(adj, 2, 4, 3);
        addE(adj, 3, 2, 6);
        addE(adj, 3, 4, -2);
        addE(adj, 5, 3, 1);

        //Negative Edge
//        addE(adj, 3, 1, -2);

        int[] ans = bellManf(6, adj, 0);

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] +" ");
        }
    }

    public static void addE(ArrayList<ArrayList<Integer>> adj, int s, int d, int w){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(s);
        temp.add(d);
        temp.add(w);

        adj.add(temp);
    }

    public static int[] bellManf(int v, ArrayList<ArrayList<Integer>> adj, int s){
        int[] dist = new int[v];
        for(int i=0; i<v; i++) dist[i] = (int) (1e8);

        dist[s] = 0;

        for(int i=0; i<v-1; i++){
            for(ArrayList<Integer> it : adj){
                int sr = it.get(0);
                int d = it.get(1);
                int wt = it.get(2);

                if(dist[sr] != 1e8 && dist[sr] + wt < dist[d]){
                    dist[d] = dist[sr] + wt;
                }
            }
        }

        for(ArrayList<Integer> it : adj){
            int sr = it.get(0);
            int d = it.get(1);
            int wt = it.get(2);

            if(dist[sr] != 1e8 && dist[sr] + wt < dist[d]){
                return new int[] {-1};
            }
        }

        return dist;
    }
}
