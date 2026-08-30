class Solution {
    static final long MOD = 1000000007;

    public static long power(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }

    public int sumDecoded(long[] nums) {
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            long n = nums[i];

            int width = (int)(n % 10);
            long d = n / 10;


            long temp = d;
            int digits = 0;

            while (temp > 0) {
                digits++;
                temp /= 10;
            }

            int yDigits = digits - width;

            long divisor = 1;
            for (int j = 0; j < yDigits; j++) {
                divisor *= 10;
            }

            long x = d / divisor;
            long y = d % divisor;

            ans = (ans + power(x, y)) % MOD;
        }

        return (int) ans;
    }
}
