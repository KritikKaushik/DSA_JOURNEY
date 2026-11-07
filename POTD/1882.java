import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Min-heap for free servers: sorted by weight, then by index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Min-heap for busy servers: sorted by freeTime, then weight, then index
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[2], b[2]);
        });

        // Initialize free servers pool {weight, index}
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[] { servers[i], i });
        }

        long currentTime = 0;

        for (int j = 0; j < m; j++) {
            currentTime = Math.max(currentTime, (long) j);

            // If no free servers are available, jump time directly to when the next server frees up
            if (freeServers.isEmpty() && !busyServers.isEmpty()) {
                currentTime = Math.max(currentTime, busyServers.peek()[0]);
            }

            // Release all servers that have finished their tasks by currentTime
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                long[] freed = busyServers.poll();
                // freed[1] is weight, freed[2] is index
                freeServers.offer(new int[] { (int) freed[1], (int) freed[2] });
            }

            // Assign the task to the best available free server
            int[] server = freeServers.poll();
            int weight = server[0];
            int index = server[1];

            ans[j] = index;
            // Push to busy servers: {freeTime, weight, index}
            busyServers.offer(new long[] { currentTime + tasks[j], weight, index });
        }

        return ans;
    }
}
