class Solution {

    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int res = 0;

        int arr[] = new int[2];

        for (high = 0; high < nums.length; high++) {
            if (nums[high] == 0) {
                arr[0]++;
            } else {
                arr[1]++;
            }
            int len = high - low + 1;
            int maxFreq1 = arr[1];
            int diff = len - maxFreq1;

            while (diff > k) {
                if (nums[low] == 0) {
                    arr[0]--;
                } else {
                    arr[1]--;
                }
                low++;
                len = high - low + 1;
                maxFreq1 = arr[1];
                diff = len - maxFreq1;
            }

            len = high - low + 1;
            res = Math.max(res,len);

        }
        return res;

    }
}

