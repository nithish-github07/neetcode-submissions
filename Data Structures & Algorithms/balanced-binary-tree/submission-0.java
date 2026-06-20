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
    boolean res;
    public boolean isBalanced(TreeNode root) {
        res = true;
        checkBalanced(root);
        return res;
    }

    public int checkBalanced(TreeNode root){
        if(root == null) return 0;

        int leftHeight = checkBalanced(root.left);
        int rightHeight = checkBalanced(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            res = false;
        }

        return 1 + Math.max(leftHeight,rightHeight);
    }
}
