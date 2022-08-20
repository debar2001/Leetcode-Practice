class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
  
        int[][] dp = new int[n+1][n+1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        
        // 0 refuel
        dp[0][0] = startFuel;
        for (int i = 1; i <= n; i++) {
            if (stations[i-1][0] > startFuel) break;
            dp[i][0] = startFuel;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i-1][j] >= stations[i-1][0]) {
                    dp[i][j] = dp[i-1][j];
                }
                
                
                if (dp[i-1][j-1] >= stations[i-1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + stations[i-1][1]);
                }
                
            }
        }
        
  
        
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] >= target) return i;
        }
        
        return -1;
    }
}