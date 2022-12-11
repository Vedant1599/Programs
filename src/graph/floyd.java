package graph;

public class floyd {

    public static void main(String[] args) {
        int[][] adj = {
                {0, 3, 8, (int) 1e8, -4},
                {(int) 1e8, 0, (int) 1e8, 1, 7},
                {(int) 1e8, 4, 0, (int) 1e8, (int) 1e8},
                {2, (int) 1e8, -5, 0, (int) 1e8},
                {(int) 1e8, (int) 1e8, (int) 1e8, 6, 0}
        };

        floydw(adj, 5);
    }


    public static void floydw(int[][] adj, int v){
        int[][] dis = adj;
        for(int i=0; i<v; i++) {
            for (int j = 0; j < v; j++) System.out.print(dis[i][j] + " ");
            System.out.println();
        } System.out.println();
        for(int k=0; k<v; k++){
            for(int i=0; i<v; i++){
                for(int j=0; j<v; j++){
                    if(adj[i][k]==(int) 1e8 || adj[k][j]==(int) 1e8) continue;
                    adj[i][k] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }

            for(int i=0; i<v; i++) {
                for (int j = 0; j < v; j++) System.out.print(dis[i][j] + " ");
                System.out.println();
            } System.out.println();
        }

    }

    public static void shorte(int[][] adj, int v){

        int[][] dis = adj;

        for(int p=0; p<v; p++){
            int temp[][] = dis;
            for(int i=0; i<v; i++){
                for(int j=0; j<v; j++){
                    int tem = dis[i][j];

                    if(i==j) continue;

                    for(int k=0; k<v; k++){
                        tem = Math.min(tem, dis[i][k] + dis[k][j]);
                    }
                }
            }

            for(int i=0; i<v; i++){
                for(int j=0; j<v; j++) System.out.print(temp[i][j]+" ");
                System.out.println();
            } System.out.println();

            dis  = temp;
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++) System.out.print(dis[i][j]+" ");
            System.out.println();
        } System.out.println();
    }
}
