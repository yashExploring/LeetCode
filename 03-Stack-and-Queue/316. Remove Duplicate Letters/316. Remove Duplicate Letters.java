1class Solution {
2    public String removeDuplicateLetters(String s) {
3        int n = s.length();
4        Stack<Character> st = new Stack<>();
5        int[] charCnt = new int[26];
6        boolean[] isAdded = new boolean[26];
7
8        for(int i=0; i<n; i++) {
9            int x = s.charAt(i)-'a';
10            charCnt[x]++;
11        }
12
13        for(int i=0; i<n; i++) {
14            if(isAdded[s.charAt(i)-'a']) {
15                charCnt[s.charAt(i)-'a']--;
16                continue;
17            }
18
19            while(!st.isEmpty() && (s.charAt(i) < st.peek()) && (charCnt[st.peek()-'a'] > 0)) {
20                isAdded[st.peek()-'a'] = false;
21                st.pop();
22            }
23
24            
25            st.push(s.charAt(i));
26            isAdded[s.charAt(i)-'a'] = true;
27            charCnt[s.charAt(i)-'a']--;
28        }
29
30        String res = ;
31
32        while(!st.isEmpty()) {
33            res = st.peek() + res;
34            st.pop();
35        }
36
37        return res;
38    }
39}