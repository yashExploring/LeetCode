1class Solution {
2    public int minMoves2(int[] nums) {
3        Arrays.sort(nums);
4        
5        int n = nums.length;
6
7        int x = (nums[n/2]);
8        int cnt = 0;
9
10        for(int i=0; i<n; i++) {
11            cnt += Math.abs(x-nums[i]);
12        }
13
14        return cnt;
15    }
16}