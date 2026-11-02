1class Solution {
2    public int minMoves(int[] nums) {
3        int n = nums.length;
4        
5        int minVal = Integer.MAX_VALUE;
6
7        for(int i=0; i<n; i++) {
8            minVal = Math.min(minVal, nums[i]);
9        }
10
11        int sum = 0;
12        for(int i=0; i<n; i++) {
13            sum += (nums[i]-minVal);
14        }
15
16        return sum;
17    }
18}