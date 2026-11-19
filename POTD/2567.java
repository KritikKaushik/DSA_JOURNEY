
import java.util.*;

class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        return Math.min(
            Math.min(nums[n-1] - nums[2], nums[n-2] - nums[1]),
            nums[n-3] - nums[0]
        );
    }
}
