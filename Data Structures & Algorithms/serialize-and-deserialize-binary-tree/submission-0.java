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

public class Codec {
    
    public void serializeTree(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append('-').append(',');
            return;
        }
        sb.append((char)(root.val + '0')).append(',');
        serializeTree(root.left, sb);
        serializeTree(root.right, sb);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeTree(root,sb);
        return sb.toString();
    }

    int ind;
    public TreeNode deserializeString(TreeNode root, String data){
        if(data.charAt(ind) == ',') ind++;
        if(data.charAt(ind) == '-'){
            ind++;
            return null;
        }
        root = new TreeNode(data.charAt(ind++) - '0');
        root.left = deserializeString(root.left,data);
        root.right = deserializeString(root.right,data);
        return root;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ind = 0;
        TreeNode root = deserializeString(null,data);
        return root;
    }
}
