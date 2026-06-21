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
    public void preOrder(TreeNode p, TreeNode q){
        if(!res || (p == null && q == null)){
            return;
        }
        if((p == null && q != null) || (p != null && q == null) || (p.val != q.val)){
            res = false;
            return;
        }
        preOrder(p.left,q.left);
        preOrder(p.right,q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        res = true;
        preOrder(p,q);
        return res;
    }
}
