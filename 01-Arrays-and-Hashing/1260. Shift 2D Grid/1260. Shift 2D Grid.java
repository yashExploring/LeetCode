1class Solution {
2    private int[] getNextIndex(int[][] grid, int i, int j, int n, int m) {
3        if(j == m-1 && i == n-1) return new int[]{0,0};
4
5        if(j == m-1) return new int[]{i+1, 0};
6
7        return new int[]{i, j+1};
8    }
9    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
10        int n = grid.length;
11        int m = grid[0].length;
12
13        while(k > 0) {
14            int i=0;
15            int j=0;
16            int tmp = grid[i][j];
17            while(true) {
18                int[] nxt = getNextIndex(grid, i, j, n, m);
19                int x = grid[nxt[0]][nxt[1]];
20                // System.out.println(tmp +   + x);
21                grid[nxt[0]][nxt[1]] = tmp;
22                tmp = x;
23                i = nxt[0];
24                j = nxt[1];
25
26                if(i == 0 && j == 0) break;
27            }
28            k--;
29        }
30
31        List<List<Integer>> arList = new ArrayList<>();
32
33        int y=0;
34        for(int[] ar : grid) {
35            arList.add(new ArrayList<Integer>());
36            for(int x : ar) {
37                arList.get(y).add(x);
38            }
39            y++;
40        }
41
42        return arList;
43    }
44}