1class Solution {
2    int vertices = 0;
3
4    private int dfs(int[][] graph, int n, int[] visited, int i) {
5        vertices++;
6        visited[i] = 1;
7        int edges = 0;
8
9        for(int j=0; j<n; j++) {
10            if(graph[i][j] == 1) {
11                if(visited[j] == 0) {
12                    edges++;
13                    edges += dfs(graph, n, visited, j);
14                } else {
15                    edges++;
16                }
17            }
18        }
19
20        return edges;
21    }
22    
23    public int countCompleteComponents(int n, int[][] edges) {
24        int m = edges.length;
25        int[][] graph = new int[n][n];
26        int totalCnt = 0;
27        
28        for(int i=0; i<m; i++) {
29            int x  = edges[i][0];
30            int y = edges[i][1];
31
32            graph[x][y] = 1;
33            graph[y][x] = 1;
34        }
35
36        int[] visited = new int[n];
37        for(int i=0; i<n; i++) {
38            if(visited[i] == 0) {
39                vertices = 0;
40                int eCnt = dfs(graph, n, visited, i)/2;
41                System.out.println(i +   + eCnt +   + vertices);
42                if(eCnt == ((vertices)*(vertices-1))/2) {
43                    totalCnt++;
44                }
45            }
46        }
47
48        return totalCnt;
49    }
50}