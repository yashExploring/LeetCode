1class Solution {
2    public boolean stoneGame(int[] piles) {
3        int n = piles.length;
4        int[][] dp = new int[n][n];
5
6        for(int i=0; i<n; i++) {
7            for(int j=0; j<n; j++) {
8                dp[i][j] = -1;
9            }
10        }
11
12        return recur(piles, 0, n-1, dp) >= 0;
13    }
14
15    private int recur(int[] piles, int a, int b, int[][] dp) {
16        if(a > b) return 0;
17
18        if(dp[a][b] != -1) return dp[a][b];
19        
20        dp[a][b] = Math.max(
21            piles[a]-recur(piles,a+1,b,dp), 
22            piles[b]-recur(piles,b,a-1,dp)
23        );
24        return dp[a][b];
25    } 
26}