package dp;
import java.util.Arrays;
import java.util.Scanner;

class DP{
    public static void main(String[] args) {
        int[] arr = {5, 8 ,1, 9, 2, 10};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 0);
        System.out.println(max_sum_nonadjecent_spaceoptimization(arr));
    }

    public static int fn_topDown(int n, int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = fn_topDown(n-1, dp) + fn_topDown(n-2, dp);
    }

    public static int fn_bottomUp(int n, int[] dp){
        dp[0] = 0; dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int fn_spaceOpt(int n){
        int prev = 0;
        int prev1 = 1;
        for(int i=2; i<=n; i++){
            int curr = prev + prev1;
            prev = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static int minEnergy(int[] ene, int ind){
        if(ind == 0) return 0;
        int left = minEnergy(ene, ind-1) + Math.abs(ene[ind]-ene[ind-1]);
        if(ind == 1) return left;
        int right = minEnergy(ene, ind-2) + Math.abs(ene[ind]-ene[ind-2]);
        return Math.min(left, right);
    }

    public static int minEnergyMemoizatoin(int[] ene, int[] dp, int ind){
        if(ind == 0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int left = minEnergyMemoizatoin(ene, dp, ind-1) + Math.abs(ene[ind-1]-ene[ind]);
        if(ind == 1) return dp[ind] = left;
        int right = minEnergy(ene, ind-2) + Math.abs(ene[ind]-ene[ind-2]);
        return dp[ind] = Math.min(left, right);
    }

    public static int minEnergyTabulation(int[] ene, int[] dp, int ind){
        dp[0] = 0;
        for(int i=1; i<=ind; i++){
            int right = Integer.MAX_VALUE;
            int left = dp[i-1] + Math.abs(ene[i]-ene[i-1]);
            if(i>1) right = dp[i-2] + Math.abs(ene[i]-ene[i-2]);
            dp[i] = Math.min(right, left);
        }
        return dp[ind];
    }

    public static int minEnergyKind(int[] ene, int[] dp, int ind, int k){
        dp[0] = 0;
        for(int i=1; i<=ind; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i>j-1){
                    int jump = dp[i-j] + Math.abs(ene[i]-ene[i-j]);
                    min = Math.min(min, jump);
                }else break;
            }
            dp[i] = min;
        }
        return dp[ind];
    }

    public static int max_sum_nonadjecent_topDown(int[] arr, int[] dp, int ind){
        if(ind>=dp.length) return 0;
        if(dp[ind]>=0) return dp[ind];
        int pick = arr[ind] + max_sum_nonadjecent_topDown(arr, dp, ind+2);
        int notpick = max_sum_nonadjecent_topDown(arr, dp, ind+1);
        return Math.max(pick, notpick);
    }
    // 2 1 4 1 5 1 6
    // 0 1 2 3 4 5 6

    public static int max_sum_nonadjecent_bottomUp(int[] arr, int[] dp){
        dp[dp.length-1] = arr[dp.length-1];
        dp[dp.length - 2] = arr[dp.length-2];
        for(int i = dp.length-3; i>=0; i--){
            int pick = arr[i] + dp[i+2];
            int notpick = dp[i+1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[0];
    }

    public static int max_sum_nonadjecent_spaceoptimization(int[] arr){
        int vprev = arr[arr.length-1];
        int sprev = arr[arr.length-2];
        for(int i=arr.length-3; i>=0; i--){
            int curr = Math.max(vprev+arr[i], sprev);
            vprev = sprev;
            sprev = curr;
        }
        return sprev;
    }
}