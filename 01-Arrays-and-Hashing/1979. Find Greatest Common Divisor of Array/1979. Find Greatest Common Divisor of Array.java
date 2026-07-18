1class Solution {
2    public int findGCD(int[] nums) {
3        int n = nums.length;
4        int smallestNum = nums[0];
5        int largestNum = nums[n-1];
6
7        for(int i=0; i<n; i++) {
8            if(nums[i] < smallestNum) {
9                smallestNum = nums[i];
10            }
11
12            if(nums[i] > largestNum) {
13                largestNum = nums[i];
14            }
15        }
16
17        return gcd(smallestNum, largestNum);
18    }
19
20    private int gcd(int a, int b) {
21        return b == 0 ? a : gcd(b, a%b);
22    }
23}