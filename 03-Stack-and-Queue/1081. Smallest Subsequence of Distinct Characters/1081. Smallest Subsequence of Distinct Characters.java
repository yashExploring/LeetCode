1class Solution {
2    public String smallestSubsequence(String s) {
3        int n = s.length();
4
5        int[] chCnt = new int[26];
6
7        for (int i = 0; i < n; i++) {
8            int x = s.charAt(i) - 'a';
9            chCnt[x]++;
10        }
11
12        Stack<Character> st = new Stack<>();
13        boolean[] isAdded = new boolean[26];
14        for (int i = 0; i < n; i++) {
15            int x = s.charAt(i) - 'a';
16            if (isAdded[x]) {
17                chCnt[x]--;
18                continue;
19            }
20
21            while (!st.isEmpty() && st.peek() > s.charAt(i) && chCnt[getIdx(st.peek())] > 0) {
22                isAdded[getIdx(st.peek())] = false;
23                st.pop();
24            }
25            st.push(s.charAt(i));
26            isAdded[x] = true;
27            chCnt[x]--;
28        }
29
30        String str = ;
31
32        while(!st.isEmpty()) {
33            str = st.peek() + str;
34            st.pop();
35        }
36
37        return str;
38    }
39
40    private int getIdx(char c) {
41        return c - 'a';
42    }
43}