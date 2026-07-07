class Solution {
	
	static int countWays(int n) {
		// add your code here
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		if (n <= 3) {
			return n;
		}
		int[] dp = new int[4];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= n; i++) {
			int curr = dp[1] + dp[2] + dp[3];
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = dp[3];
			dp[3] = curr;
		}
		return dp[3];
	}
}
