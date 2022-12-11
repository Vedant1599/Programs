package dp;
import java.util.*;
public class maximumPath {

    public static void main(String[] args) {
        System.out.println(maxPathBottom(2, 2));
        System.out.println(maxPathRecc(2, 2, 1, 1));
    }

    public static int maxPathRecc(int row, int col, int i, int j){
        if(i == row && j == col) return 0;
        if(i == row-1 && j==col) return 1;
        if(i== row && j == col-1) return 1;
        return maxPathRecc(row, col, i, j+1) + maxPathRecc(row, col, i+1, j);
    }

    public static int maxPathBottom(int row, int col){
        int[][] arr = new int[row][col];
        for(int i = row-2; i>=0; i--){
            arr[i][col-1] = row-i-1;
        }
        for(int i= col-2; i>=0; i--){
            arr[row-1][i] = col-i-1;
        }
        for(int i = row-2; i>=0; i--){
            for(int j = col-2; j>=0; j--){
                arr[i][j] = arr[i][j+1] + arr[i+1][j];
            }
        }
        return arr[0][0];
    }
}

