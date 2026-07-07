class Solution {
  
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[3];
        if(n<=1){
            return 0;
        }
        dp[0]=0;
        dp[1]=0;

        for(int i=2;i<=n;i++){
            dp[0]=dp[1];
            dp[1]=dp[2];
            dp[2]=Math.min(dp[1]+cost[i-1],dp[0]+cost[i-2]);
        }
        return dp[2];
        
    }
}
