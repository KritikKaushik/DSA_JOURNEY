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
 //left root right
class Solution {
    public void inorder(TreeNode a, List<Integer> r){
        if(a==null){
            return;
        }
       inorder(a.left,r);
       r.add(a.val);
       inorder(a.right,r);
       return;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();

        inorder(root,res);

        return res;
    }
}
