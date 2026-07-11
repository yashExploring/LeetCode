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
17    public boolean isValidBST(TreeNode root) {
18        TreeNode curr = root;
19        TreeNode prev = null;
20        Stack<TreeNode> st = new Stack<>();
21
22        while(curr != null || !(st.isEmpty())) {
23            while(curr != null) {
24                st.push(curr);
25                curr = curr.left;
26            }
27            curr = st.pop();
28            if(prev != null && prev.val >= curr.val) {
29                return false;
30            }
31
32            prev = curr;
33            curr = curr.right;
34        }
35
36        return true;
37    }
38}