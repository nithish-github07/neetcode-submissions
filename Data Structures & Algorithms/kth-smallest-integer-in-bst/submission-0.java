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
    int count;
    int res;
    public void inOrder(TreeNode root, int target){
        if(res != -1 || root == null) return;
        inOrder(root.left, target);
        count++;
        if(count == target){
            res = root.val;
            return;
        }
        inOrder(root.right,target); 
    }
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        res = -1;
        inOrder(root,k);
        return res;
    }
}
