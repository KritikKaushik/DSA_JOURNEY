
class Solution {
    

    public int climbStairs(int n) {
        
        int[] dp=new int[3];
        if(n<=2){
            return n;
        }
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[0]=dp[1];
            dp[1]=dp[2];
            dp[2]=dp[0]+dp[1];
            
        }

        return dp[2];
    }
}
