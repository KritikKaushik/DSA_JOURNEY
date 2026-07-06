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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean LR=true;
        List<List<Integer>> res=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();

        if(root==null){
            return new ArrayList<>();
        }
        q.add(root);

        while(!q.isEmpty()){
            int lvlsize=q.size();
            List<Integer>tmp=new ArrayList<>(lvlsize);
            while(lvlsize-->0){
                TreeNode t=q.peek();
                q.remove();
                tmp.add(t.val);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            if(LR==true){
                res.add(new ArrayList<>(tmp));
                LR=false;
            }else{
                Collections.reverse(tmp);
                res.add(new ArrayList<>(tmp));
                LR=true;
            }

            
        }
        return res;
    }
}
