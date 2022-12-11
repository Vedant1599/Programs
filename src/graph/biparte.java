package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class biparte {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<10; i++){
            adj.add(new ArrayList<>());
        }

        addE(adj, 0, 1);
        addE(adj, 1, 2);
        addE(adj, 1, 6);
        addE(adj, 2, 3);
        addE(adj, 6, 5);
        addE(adj, 3, 4);
        addE(adj, 4, 5);
        addE(adj, 4, 7);
        addE(adj, 8, 9);
        ArrayList<ArrayList<Integer>> bipar = new ArrayList<>();

        boolean flag = isBipatite(adj, 10, bipar);
        if(flag){
            System.out.print("Colour 0 : ");
            for(int i=0; i<bipar.get(0).size(); i++){
                System.out.print(bipar.get(0).get(i)+" ");
            }
            System.out.println();
            System.out.print("Colour 1 : ");
            for(int i=0; i<bipar.get(1).size(); i++){
                System.out.print(bipar.get(1).get(i)+" ");
            }
        }else{
            System.out.println("Not Bipartite");
        }

    }

    public static void addE(ArrayList<ArrayList<Integer>> adj, int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
    public static boolean isBipatiteH(ArrayList<ArrayList<Integer>> adj, int[] col, int me){
        Queue<Integer> q = new LinkedList<>();
        q.add(me);
        col[me] = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int adjNode : adj.get(node)){
                //if adjNode is not color give opposite color of node
                if(col[adjNode] == -1){
                    if(col[node]==1) col[adjNode]=0;
                    else col[adjNode]=1;
                    q.add(adjNode);
                }else{
                    if(col[node]==col[adjNode]) return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipatite(ArrayList<ArrayList<Integer>> adj, int v, ArrayList<ArrayList<Integer>> bipar){
        int col[] = new int[v];
        Arrays.fill(col, -1);

        for(int i=0; i<v; i++){
            if(col[i]==-1){
                if(isBipatiteH(adj, col, i)==false) return false;
            }
        }


        bipar.add(new ArrayList<Integer>());
        bipar.add(new ArrayList<Integer>());

        for(int i=0; i<v; i++){
            bipar.get(col[i]).add(i);
        }

        return true;
    }

}
