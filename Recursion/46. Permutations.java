class Solution {
    public void help(int[] nums,boolean[] visited,List<Integer> tmp,List<List<Integer>> ans){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==true){
                continue;
            }
            visited[i]=true;
            tmp.add(nums[i]);
            help(nums,visited,tmp,ans);

            tmp.remove(tmp.size()-1);
            visited[i]=false;
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean[] v=new boolean[nums.length];
        help(nums,v,temp,ans);
        return ans;
        
    }
}
