1class Solution {
2    public int maxDepth(String s) {
3        int n = s.length();
4        int currDepth = 0;
5        int maxDepth = 0;
6        for(int i=0; i<n; i++) {
7            if(s.charAt(i) == '(') {
8                currDepth++;
9                maxDepth = Math.max(maxDepth, currDepth);
10            } else if(s.charAt(i) == ')') {
11                currDepth--;
12            }
13        }
14
15        return maxDepth;
16    }
17}