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
    public void checkValidBST(TreeNode root, int min, int max){
        if(!res || root == null){
            return;
        }
        if(root.val <= min || root.val >= max){
            res = false;
        }
        checkValidBST(root.left,min,root.val);
        checkValidBST(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        res = true;
        checkValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return res;
    }
}
