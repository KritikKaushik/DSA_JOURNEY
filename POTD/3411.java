class Solution {
    public int maxLength(int[] nums) {
        // Since 1 <= nums[i] <= 10, max possible LCM of any subset is 2520.
        // For length 2, prod == lcm * gcd is always true; for longer subarrays,
        // prod cannot exceed max_lcm * max_element (2520 * 10 = 25200).
        final int MAX_PROD = 25200;
        int n = nums.length;
        int maxLen = 2; // Any subarray of length 2 always satisfies prod(a,b) == lcm(a,b) * gcd(a,b)

        for (int i = 0; i < n; i++) {
            int prod = 1;
            int currentLcm = 1;
            int currentGcd = 0;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                if (prod > MAX_PROD) {
                    break; // Prevent integer overflow and prune impossible subarrays
                }

                currentLcm = lcm(currentLcm, nums[j]);
                currentGcd = gcd(currentGcd, nums[j]);

                if (prod == currentLcm * currentGcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
