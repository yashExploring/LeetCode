1class Solution {
2    public int trap(int[] height) {
3        int n = height.length;
4
5        int maxLeftHeight = height[0];
6        int maxRightHeight = height[n-1];
7
8        int i=1;
9        int j=n-2;
10
11        int ans = 0;
12
13        while(i <= j) {
14            if(maxLeftHeight < maxRightHeight) {
15                if(height[i] < maxLeftHeight) {
16                    ans += (maxLeftHeight-height[i]);
17                } else {
18                    maxLeftHeight = height[i];
19                }
20                i++;
21            } else {
22                if(height[j] < maxRightHeight) {
23                    ans += (maxRightHeight-height[j]);
24                } else {
25                    maxRightHeight = height[j];
26                }
27                j--;
28            }
29        }
30
31        return ans;
32    }
33}