1class Solution {
2
3    static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
4    public int maximumSafenessFactor(List<List<Integer>> grid) {
5        int n = grid.size();
6        int m = grid.get(0).size();
7
8        int[][] thiefDistance = new int[n][m];
9
10        Queue<int[]> thiefDistQueue = new LinkedList<>();
11        
12        for(int i=0; i<n; i++) {
13            for(int j=0; j<m; j++) {
14                thiefDistance[i][j] = Integer.MAX_VALUE;
15                if(grid.get(i).get(j) == 1) {
16                    thiefDistance[i][j] = 0;
17                    thiefDistQueue.add(new int[]{i, j});
18                }
19            }
20        }
21
22        while(!thiefDistQueue.isEmpty()) {
23            int[] curr = thiefDistQueue.poll();
24            int x = curr[0];
25            int y = curr[1];
26            for(int[] d : delta) {
27                int nX = x + d[0];
28                int nY = y + d[1];
29
30                if(isValidPosition(nX, nY, n, m) && thiefDistance[nX][nY] > thiefDistance[x][y] + 1) {
31                    thiefDistance[nX][nY] = thiefDistance[x][y] + 1;
32                    thiefDistQueue.add(new int[]{nX, nY});
33                }
34            }
35        }
36
37
38        // for(int i=0; i<n; i++) {
39        //     for(int j=0; j<m; j++) {
40        //         System.out.print(thiefDistance[i][j] +  );
41        //     }
42        //     System.out.println();
43        // }
44
45        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
46            (a, b) -> b[2] - a[2]
47                
48        );
49
50        int currMin = Integer.MAX_VALUE;
51        pq.add(new int[]{0, 0, thiefDistance[0][0]});
52        thiefDistance[0][0] = -1;
53
54        while(!pq.isEmpty()) {
55            int[] pnt = pq.poll();
56            int x = pnt[0];
57            int y = pnt[1];
58            currMin = Math.min(currMin, pnt[2]);
59            if(x == n-1 && y == m-1) return currMin;
60
61            for(int[] d : delta) {
62                int nX = x + d[0];
63                int nY = y + d[1];
64                if(isValidPosition(nX, nY, n, m) && thiefDistance[nX][nY] != -1) {
65                    pq.add(new int[]{nX, nY, thiefDistance[nX][nY]});
66                    thiefDistance[nX][nY] = -1;
67                }
68            }            
69        }
70
71        return currMin;
72    }
73
74    private boolean isValidPosition(int nX, int nY, int n, int m) {
75        return nX >= 0 && nX < n && nY >= 0 && nY < m;
76    }
77}