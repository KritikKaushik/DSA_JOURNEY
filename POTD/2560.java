class Solution {
    public boolean helper(int target,int[] nums,int k){
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target){
                i++;
                cnt++;
            }
        }
        if(cnt>=k){
            return true;
        }
        return false;
    }
    public int minCapability(int[] nums, int k) {
        int low=0;
        int high=1000000000;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(high+low)/2;
            if(helper(mid,nums,k)==true){
                ans=Math.min(ans,mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
