1class Solution {
2    public int minScore(int n, int[][] roads) {
3        int m = roads.length;
4
5        DSU dsu = new DSU(n);
6        for(int i=0; i<m; i++) {
7            dsu.takeUnion(roads[i][0]-1, roads[i][1]-1);
8        }
9
10        int minVal = Integer.MAX_VALUE;
11        int parentA = dsu.findParent(0);
12        for(int i=0; i<m; i++) {
13            int parentB = dsu.findParent(roads[i][0]-1);
14            if(parentB == parentA) {
15                minVal = Math.min(minVal, roads[i][2]);
16            }
17        }
18
19        return minVal;
20    }
21}
22
23class DSU {
24    int n;
25    int[] parent;
26
27    DSU(int x) {
28        n = x;
29        parent = new int[n];
30
31        for(int i=0; i<n; i++) {
32            parent[i] = i;
33        }
34    }
35
36    void takeUnion(int a, int b) {
37        int pA = findParent(a);
38        int pB = findParent(b);
39        parent[pA] = pB;
40    }
41
42    int findParent(int a) {
43        int root = a;
44        while(root != parent[root]) {
45            root = parent[root];
46        }
47
48        int curr = a;
49        while(curr != parent[curr]) {
50            int x = parent[curr];
51            parent[curr] = root;
52            curr = x;
53        }
54
55        return root;
56    }
57}