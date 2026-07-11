class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int i=0;
        int sum=nums[i];
        int nsum=nums[i];
        int ans=Math.abs(nums[i]);
        

        for(i=1;i<nums.length;i++){
            sum=Math.max(nums[i],sum+nums[i]);

            nsum=Math.min(nums[i],nsum+nums[i]);

            ans=Math.max(ans,Math.max(sum,Math.abs(nsum)));

        }
        return ans;
    }
}

