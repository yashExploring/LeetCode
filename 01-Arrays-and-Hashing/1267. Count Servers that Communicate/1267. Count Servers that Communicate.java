1class Solution {
2    public int countServers(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        int totalCnt = 0;
6        int isolatedCnt = 0;
7        for(int i=0; i<n; i++) {
8            int rowCnt = 0;
9            int col = -1;
10            for(int j=0; j<m; j++) {
11                if(grid[i][j] == 1) {
12                    totalCnt++; 
13                    col = j;
14                    rowCnt++;
15                }
16            }
17
18            int colCnt = 0;
19            if(rowCnt == 1) {
20                for(int x=0; x<n; x++) {
21                    if(grid[x][col] == 1) {
22                        colCnt++;
23                    }
24                }
25
26                if(colCnt == 1) {
27                    isolatedCnt++;
28                }
29            }
30        }
31
32        return totalCnt - isolatedCnt;
33    }
34}