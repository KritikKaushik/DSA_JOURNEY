class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] e:edges){
            adj[e[0]].add(new int[]{e[1],e[2]});
        }

        int[][] dist = new int[n][k+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        dist[0][1] = 0;
        pq.offer(new int[]{0,0,1});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int cost = curr[0];
            int u = curr[1];
            int count = curr[2];

            if(cost>dist[u][count]) continue;

            if(u==n-1) return cost;

            for(int[] e:adj[u]){
                int v = e[0];
                int w = e[1];

                int nc = 1;

                if(labels.charAt(u)==labels.charAt(v)){
                    nc = count+1;
                }

                if(nc>k) continue;

                int newCost = cost+w;

                if(newCost<dist[v][nc]){
                    dist[v][nc] = newCost;
                    pq.offer(new int[]{newCost,v,nc});
                }
            }
        }

        return -1;
    }
}
