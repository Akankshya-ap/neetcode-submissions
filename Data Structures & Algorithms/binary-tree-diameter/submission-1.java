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
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root!=null){
            height(root);
        }
        return maxDiameter;
    }

    private int height(TreeNode node){
        if(node == null) return 0;
        int maxHeightFromLeft = height(node.left);
        int maxHeightFromRight = height(node.right);
        int maxLeftRight = Math.max(maxHeightFromLeft, maxHeightFromRight);
        maxDiameter = Math.max(maxDiameter,maxHeightFromLeft+ maxHeightFromRight);

        return maxLeftRight+1;
    }
}
