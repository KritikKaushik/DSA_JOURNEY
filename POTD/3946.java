
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];
        int mn = Integer.MAX_VALUE;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            mn = Math.min(mn, price);

            int cnt = 0;

            for (int[] x : items) {
                if (x[0] % factor == 0) {
                    cnt++;
                }
            }

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + cnt);
            }
        }

        int ans = 0;

        for (int i = 0; i <= budget; i++) {
            ans = Math.max(ans, dp[i] + (budget - i) / mn);
        }

        return ans;
    }
}
