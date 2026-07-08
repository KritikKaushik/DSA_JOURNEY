/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans=null;
    public int boss(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return 0;
        }
        int left=boss(root.left,p,q);
        int right=boss(root.right,p,q);
        int self=0;
        if(root==p||root==q){
            self=1;
        }
        int sub=left+right+self;
        if(sub==2 && ans==null){
            ans=root;
        }
        return sub;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boss(root,p,q);
        return ans;
    }
}
