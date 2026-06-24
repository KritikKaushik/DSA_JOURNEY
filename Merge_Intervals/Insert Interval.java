class Solution {
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (end >= s) {
                end = Math.max(end, e);
            } else {
                ans.add(new int[] { start, end });
                start = s;
                end = e;
            }
        }
        ans.add(new int[] { start, end });
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansa = new ArrayList<>();
        boolean insert = false;

        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        int nstart = newInterval[0];
        int nend = newInterval[1];
        
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= nstart && insert == false) {
                ansa.add(new int[] { nstart, nend });
                insert = true;
            }
            ansa.add(new int[] { start, end });
        }
        if (!insert) {
            ansa.add(new int[] { nstart, nend });
        }

        return merge(ansa.toArray(new int[ansa.size()][]));

    }
}
