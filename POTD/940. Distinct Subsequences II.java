import java.util.*;

class Solution {

    public static final int MOD = (int) 1e9 + 7;

    public int[] dp;
    public int[] prev;
    public int[] lastSeen;

    public int solve(int n) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int total = (int) ((2L * solve(n - 1)) % MOD);
        if (prev[n] != 0) {
            int duplicates = solve(prev[n] - 1);
            total = (int) (((long) total - duplicates + MOD) % MOD);
        }
        return dp[n] = total;
    }

    public int distinctSubseqII(String s) {

        int n = s.length();

        dp = new int[n + 1];
        prev = new int[n + 1];
        lastSeen = new int[26];

        Arrays.fill(dp, -1);

        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }
        return (solve(n) - 1 + MOD) % MOD;
    }
}
