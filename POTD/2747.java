
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int m = queries.length;
        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] ans = new int[m];
        int[] count = new int[n + 1];

        int l = 0, r = 0;
        int unique = 0;

        for (int i = 0; i < m; i++) {
            int start = q[i][0] - x;
            int end = q[i][0];

            while (r < logs.length && logs[r][1] <= end) {
                int id = logs[r][0];

                if (count[id] == 0) {
                    unique++;
                }

                count[id]++;
                r++;
            }

            while (l < r && logs[l][1] < start) {
                int id = logs[l][0];

                count[id]--;

                if (count[id] == 0) {
                    unique--;
                }

                l++;
            }

            ans[q[i][1]] = n - unique;
        }

        return ans;
    }
}
