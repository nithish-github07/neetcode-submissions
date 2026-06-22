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
    public void countGoodNodes(TreeNode root, int max){
        if(root == null) return;
        if(max <= root.val){
            max = root.val;
            count++;
        }
        countGoodNodes(root.left,max);
        countGoodNodes(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        count = 0;
        countGoodNodes(root,root.val);
        return count;
        
    }
}
