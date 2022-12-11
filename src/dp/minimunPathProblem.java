package dp;
public class minimunPathProblem {
    public static void main(String[] args) {
        int[][] arr = { {1,3,1}, {1, 5, 1}, {4,2,1}};
        System.out.println(minRecc(arr, 0, 0));
        int[][] dp = new int[arr.length][arr[0].length];
        System.out.println(minDp(arr, dp, 0, 0));
    }

    //  10   8   2
    //  10   5 100
    //   1   1   2

    public static int minRecc(int[][] arr, int i, int j){
        int row = arr.length;
        int col = arr[0].length;
        if(i==row-1 && j==col-1) return arr[i][j];
        if(i==row-1) return minRecc(arr, i, j+1) + arr[i][j];
        if(j==col-1) return minRecc(arr, i+1, j) + arr[i][j];

        int a = arr[i][j] + minRecc(arr, i+1, j);
        int b = arr[i][j] + minRecc(arr, i, j+1);

        return Math.min(a, b);
    }

    public static int minDp(int[][] arr, int[][] dp, int i, int j){
        int row = arr.length;
        int col = arr[0].length;
        if(i==row-1 && j==col-1) return dp[i][j] = arr[i][j];
        if(i==row-1) return dp[i][j] = minDp(arr, dp, i, j+1) + arr[i][j];
        if(j==col-1) return dp[i][j] = minDp(arr, dp,i+1, j) + arr[i][j];

        if(dp[i][j]!=0) return dp[i][j];

        int a = arr[i][j] + minDp(arr, dp, i+1, j);
        int b = arr[i][j] + minDp(arr, dp, i, j+1);

        return dp[i][j] = Math.min(a, b);

    }
}
