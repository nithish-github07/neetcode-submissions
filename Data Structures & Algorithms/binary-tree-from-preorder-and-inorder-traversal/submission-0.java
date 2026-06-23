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
    int preind;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preind = 0;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return constructTree(null,0,inorder.length-1,preorder);
    }
    
    public TreeNode constructTree(TreeNode root, int left, int right, int[] preorder){
        if(left > right) return null;
        root = new TreeNode(preorder[preind++]);
        int ind = map.get(root.val);

        root.left = constructTree(root,left,ind-1,preorder);
        root.right = constructTree(root,ind+1,right,preorder);
        return root;
    }
}
