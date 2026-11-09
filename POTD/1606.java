import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }

        // Min-heap for busy servers: stores long[] of {freeTime, serverId}
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        int[] requestCount = new int[k];
        int maxRequests = 0;

        for (int i = 0; i < arrival.length; i++) {
            long currTime = arrival[i];
            int duration = load[i];

            // Release all servers that have finished their tasks by currTime
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                long[] freed = busyServers.poll();
                availableServers.add((int) freed[1]);
            }

            // If all servers are busy, the request is dropped
            if (availableServers.isEmpty()) {
                continue;
            }

            // Find the first available server >= (i % k)
            Integer server = availableServers.ceiling(i % k);
            // If none found, wrap around and pick the first available server from index 0
            if (server == null) {
                server = availableServers.first();
            }

            // Assign request to the selected server
            availableServers.remove(server);
            busyServers.offer(new long[] { currTime + duration, server });
            
            requestCount[server]++;
            maxRequests = Math.max(maxRequests, requestCount[server]);
        }

        // Collect all servers that handled the maximum number of requests
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}
