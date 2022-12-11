package graph;

import java.util.Queue;
import java.util.LinkedList;

public class DistanceOfNearestCell {

    public static void main(String[] args) {
        int[][] g1 = {{0,0,0}, {0,1,0}, {1,0,1}};

        int[][] dis = nearest(g1);
        print(dis);


    }

    static class Node{
        int row;
        int col;
        int dis;
        Node(int row, int col, int dis){
            this.row = row; this.col = col; this.dis = dis;
        }
    }


    public static int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];

        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else vis[i][j]=0;
            }
        }

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int step = q.peek().dis;
            q.remove();

            dis[row][col] = step;

            for(int i=0; i<4; i++){
                int nr = row+delr[i];
                int nc = col+delc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0){
                    vis[nr][nc] = 1;
                    q.add(new Node(nr,nc,step+1));
                }
            }
        }

        return dis;
    }

    public static void print(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for(int i=0; i<n; i++){
            for (int j = 0; j < m; j++) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
