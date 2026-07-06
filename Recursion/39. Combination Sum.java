class Solution {
    public void help(int[] candidate,int target,int index,int n,List<Integer> dairy,List<List<Integer>> res,int sum){
        if(index==n){
            if(sum==target){
                res.add(new ArrayList<>(dairy));
            }
            return;
        }

        //move forward dont take
        help(candidate,target,index+1,n,dairy,res,sum);

        if(sum+candidate[index]<=target){
            dairy.add(candidate[index]);
            sum+=candidate[index];
            help(candidate,target,index,n,dairy,res,sum);
            dairy.remove(dairy.size()-1);
            sum-=candidate[index];
        }
        return;

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        help(candidates,target,0,candidates.length,temp,ans,0);
        return ans;
        
    }
}
