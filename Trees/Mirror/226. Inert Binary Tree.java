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
    private void swap(TreeNode root){

        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
    }
    private void invert(TreeNode root){
        if(root==null){
            return;
        }
        swap(root);
        invert(root.left);
        invert(root.right);
        return;

    }
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}
