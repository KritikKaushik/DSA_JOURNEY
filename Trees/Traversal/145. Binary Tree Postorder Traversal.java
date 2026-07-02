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
 //left right root
class Solution {
    public void postOrder(TreeNode m,List<Integer> r){
        if(m==null){
            return;
        }
        postOrder(m.left,r);
        postOrder(m.right,r);
        r.add(m.val);
        return;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();

        postOrder(root,res);
        
        return res;
        
    }
}
