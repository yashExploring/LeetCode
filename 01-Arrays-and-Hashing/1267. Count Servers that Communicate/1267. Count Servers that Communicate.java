1class Solution {
2    public int countServers(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        
6        int dC = 0;
7        int totalCnt = 0;
8        for(int i=0; i<n; i++) {
9            int cnt = 0;
10            int lJ = 0;
11            for(int j=0; j<m; j++) {
12                if(grid[i][j] == 1) {
13                    lJ = j;
14                    totalCnt++;
15                    cnt++;
16                }
17            }
18
19            if(cnt == 1) {
20                int nC = 0;
21                for(int j=0; j<n; j++) {
22                    if(grid[j][lJ] == 1) {
23                        nC++;
24                    }
25                }
26
27                if(nC == 1) {
28                    dC++;
29                }
30            }
31        }
32        
33        return totalCnt-dC;
34    }
35}