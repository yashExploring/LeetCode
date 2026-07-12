1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public void recoverTree(TreeNode root) {
18        TreeNode curr = root;
19        Stack<TreeNode> st = new Stack<>();
20        TreeNode prev = null;
21
22        TreeNode first = null;
23        TreeNode second = null;
24
25        while((curr!=null)||(!st.isEmpty())) {
26            while(curr!=null) {
27                st.push(curr);
28                curr = curr.left;
29            }
30            curr = st.pop();
31            if(prev != null && (prev.val > curr.val)) {
32                if(first == null) {
33                    first = prev;
34                    second = curr;
35                } else {
36                    second = curr;
37                }
38            }
39
40            prev = curr;
41            curr = curr.right;
42        }
43
44        first.val = second.val ^ first.val;
45        second.val = second.val ^ first.val;
46        first.val = second.val ^ first.val;
47
48        
49    }
50}