class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[3];
        int size = nums.length;

        if (size == 1) {
            return nums[0];
        }
        if (size == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = dp[1];

        for (int i = 2; i < size - 1; i++) {
            dp[2] = Math.max(nums[i] + dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        int result1 = dp[2];

        //second array
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        dp[2] = dp[1];

        for (int i = 3; i < size; i++) {
            dp[2] = Math.max(nums[i] + dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return Math.max(dp[2], result1);
    }
}
