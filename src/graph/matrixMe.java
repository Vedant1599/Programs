package graph;

public class matrixMe {

    public static void main(String[] args) {
        int[][] adj = {{0, 2, 8, (int) 1e8, -4}, {(int) 1e8, 0, (int) 1e8, 4, 7}, {(int) 1e8, 4, 0, (int) 1e8, (int) 1e8},
                {2, (int) 1e8, -5, 0, (int) 1e8}, {(int) 1e8, (int) 1e8, (int) 1e8, 6, 0}};

        shorte(adj, 5);
    }
    public static void shorte(int[][] adj, int v){
        int[][] dis = adj;

        for(int p=0; p<v; p++){
            int[][] tempdis = new int[v][v];

            for(int i=0; i<v; i++){
                for(int j=0; j<v; j++){
                    int tem = dis[i][j];
                    for(int k=0; k<v; k++){
                        tem = Math.min(tem, dis[i][k] + adj[k][j]);
                    }

                    tempdis[i][j] = tem;
                }
            }

            for(int i=0; i<v; i++){
                for(int j=0; j<v; j++){
                    System.out.print(tempdis[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();

            dis = tempdis;
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }
    }
}
