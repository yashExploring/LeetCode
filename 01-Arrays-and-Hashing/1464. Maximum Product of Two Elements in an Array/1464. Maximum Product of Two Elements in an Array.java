1class Solution {
2    public int maxProduct(int[] nums) {
3        int n = nums.length;
4        int maxProd = (nums[0]-1)*(nums[1]-1);
5        for(int i=0; i<n; i++) {
6            for(int j=i+1; j<n; j++) {
7                maxProd = Math.max(maxProd, (nums[i]-1)*(nums[j]-1));
8            }
9        }
10
11        return maxProd;
12    }
13}