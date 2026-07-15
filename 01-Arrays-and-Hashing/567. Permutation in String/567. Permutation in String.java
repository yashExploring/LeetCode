1class Solution {
2    public boolean checkInclusion(String s1, String s2) {
3        int[] charCnt = new int[26];
4
5        int n = s1.length();
6        int m = s2.length();
7
8        for(int i=0; i<n; i++){ 
9            charCnt[s1.charAt(i)-'a']++;
10        }
11
12        int[] tmpCnt = new int[26];
13        restore(tmpCnt, charCnt);
14
15        int i=0;
16        while(i<m) {
17            if(tmpCnt[s2.charAt(i)-'a'] > 0) {
18                int j = i;
19                while(j < m) {
20                    // System.out.println(i +   + j +   );
21                    int idx = s2.charAt(j)-'a';
22                    if(tmpCnt[idx] > 0) {
23                        tmpCnt[idx]--;
24                        j++;
25                    } else {
26                        if(charCnt[idx] == 0) {
27                            restore(tmpCnt, charCnt);
28                            // System.out.println(breaking);
29                            i = j+1;
30                            break;
31                        } else {
32                            tmpCnt[s2.charAt(i)-'a']++;
33                            i++;
34                        }
35                    }
36                    if(isValid(tmpCnt)) return true;
37                }
38                i = j+1;
39            } else {
40                i++;
41            }
42        }
43        return false;
44    }
45
46    private boolean isValid(int[] chCnt) {
47        for(int i=0; i<26; i++) {
48            if(chCnt[i] > 0) return false;
49        }
50        return true;
51    }
52
53    private void restore(int[] a, int[] b) {
54        for(int i=0; i<26; i++) {
55            a[i] = b[i];
56        }
57    }
58}