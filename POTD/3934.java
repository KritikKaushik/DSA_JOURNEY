
import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int low = 1, high = n;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int k) {
        int n = nums.length;
        long base = 1000003L;
        long mod = 1000000007L;

        long power = 1;
        for (int i = 1; i < k; i++) {
            power = (power * base) % mod;
        }

        long hash = 0;

        for (int i = 0; i < k; i++) {
            hash = (hash * base + nums[i]) % mod;
        }

        Map<Long, Integer> freq = new HashMap<>();
        freq.put(hash, 1);

        for (int i = k; i < n; i++) {
            hash = (hash - nums[i - k] * power % mod + mod) % mod;
            hash = (hash * base + nums[i]) % mod;

            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
