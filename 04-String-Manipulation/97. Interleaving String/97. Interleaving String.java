1class Solution {
2    private boolean recur(String s1, String s2, String s3, int a, int b, int[][] dp) {
3        if (a == 0 && b == 0) return true;
4
5        // if (a == 0 || b == 0) return false;
6        if(a == 0) {
7            // System.out.println(s2.substring(0, b) +   + s3.substring(0, b));
8            if(s2.substring(0, b).equals(s3.substring(0, b))) {
9                dp[a][b] = 1;
10                return true;
11            }
12            dp[a][b] = 0;
13            return false;
14        }
15
16        if(b == 0) {
17            // System.out.println(s1.substring(0, a) +   + s3.substring(0, a));
18            if(s1.substring(0, a).equals(s3.substring(0, a))) {
19                dp[a][b] = 1;
20                return true;
21            }
22            dp[a][b] = 0;
23            return false;
24        }
25
26        if(dp[a][b] != -1) {
27            if(dp[a][b] == 1) return true;
28            return false;
29        }
30
31        if(s1.charAt(a-1) == s3.charAt(a+b-1)) {
32            boolean result = recur(s1, s2, s3, a-1, b, dp);
33            if(result) {
34                dp[a][b] = 1;
35                return result;
36            }
37        }
38
39        if(s2.charAt(b-1) == s3.charAt(a+b-1)) {
40            boolean result = recur(s1, s2, s3, a, b-1, dp);
41            if(result) {
42                dp[a][b] = 1;
43                return result;
44            }
45        }
46        dp[a][b] = 0;
47        return false;
48    }
49
50    public boolean isInterleave(String s1, String s2, String s3) {
51        int n = s1.length();
52        int m = s2.length();
53        int l = s3.length();
54        if(n+m != l) return false;
55        int[][] dp = new int[n+1][m+1];
56        
57        for(int i=0; i<=n; i++) {
58            for(int j=0; j<=m; j++) {
59                dp[i][j] = -1;
60            }
61        }
62        return recur(s1, s2, s3, n, m, dp);
63    }
64}