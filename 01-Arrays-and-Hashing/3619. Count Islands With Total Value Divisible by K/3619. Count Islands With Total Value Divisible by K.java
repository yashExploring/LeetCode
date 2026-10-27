1class Solution {
2    public long dfs(int[][] grid, int i, int j, int n, int m) {
3        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) return 0L;
4
5        long sum = grid[i][j];
6        grid[i][j] = 0;
7        sum += dfs(grid, i+1, j, n, m);
8        sum += dfs(grid, i-1, j, n, m);
9        sum += dfs(grid, i, j+1, n, m);
10        sum += dfs(grid, i, j-1, n, m);
11
12        return sum;
13    }
14    
15    public int countIslands(int[][] grid, int k) {
16        int n = grid.length;
17        int m = grid[0].length;
18        int cnt = 0;
19        for(int i=0; i<n; i++) {
20            for(int j=0; j<m; j++) {
21                if(grid[i][j] != 0) {
22                    long sum = dfs(grid, i, j, n, m);
23
24                    if(sum%k == 0) {
25                        cnt ++;
26                    }
27                }
28            }
29        }
30        return cnt;
31    }
32}