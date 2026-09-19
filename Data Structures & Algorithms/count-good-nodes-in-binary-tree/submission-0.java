/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int res = 0;
    public int goodNodes(TreeNode root) {
        if(root!=null){
            check(root, root.val);
        }
        return res;
    }

    private void check(TreeNode node, int maxTillNow){
        if(node!=null){
            if(node.val>=maxTillNow) res++;
            check(node.left, Math.max(maxTillNow, node.val));
            check(node.right, Math.max(maxTillNow, node.val));
        }
    }
}
