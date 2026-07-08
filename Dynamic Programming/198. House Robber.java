class Solution {
    public int rob(int[] nums) {
        int size=nums.length;
        if(size==1){
            return nums[0];
        }
        if(size==2){
            return Math.max(nums[0],nums[1]);
        }

        int[] dp=new int[3];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        dp[2]=dp[1];

        for(int i=2;i<size;i++){
            dp[2]=Math.max(nums[i]+dp[0],dp[1]);
            dp[0]=dp[1];
            dp[1]=dp[2];
        }

        return dp[2];
        
    }
}
