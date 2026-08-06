1class Solution {
2    public int smallestNumber(int n, int t) {
3        while(true) {
4            if(digitsProd(n)%t == 0) {
5                return n;
6            }
7            n++;
8        }
9    }
10
11    private int digitsProd(int n) {
12        int prod = 1;
13        while(n > 0) {
14            int rem = n%10;
15            n = n/10;
16
17            if(rem == 0) return 0;
18            prod *= rem;
19        }
20
21        return prod;
22    }
23}