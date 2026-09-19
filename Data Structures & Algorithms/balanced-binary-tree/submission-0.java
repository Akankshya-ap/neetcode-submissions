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
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        
        if(root!=null){
            height(root);
        }
        return flag;
    }

    private int height(TreeNode node){
        if(node==null) return 0;

        int nodeLeft = height(node.left);
        int nodeRight = height(node.right);
        if(Math.abs(nodeLeft-nodeRight)>1) flag = false;

        return 1+Math.max(nodeLeft, nodeRight);
    }
}
