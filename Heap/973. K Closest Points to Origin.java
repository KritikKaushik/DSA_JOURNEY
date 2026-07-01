class Pair {
    int dist;
    int index;

    Pair(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }
}

class Solution {

    public int calDist(int[] cor) {
        int x = cor[0];
        int y = cor[1];
        return x * x + y * y;
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.dist - a.dist   
        );

        for (int i = 0; i < points.length; i++) {
            Pair curr = new Pair(calDist(points[i]), i);

            if (pq.size() < k) {
                pq.add(curr);
            } else if (curr.dist < pq.peek().dist) {
                pq.poll();
                pq.add(curr);
            }
        }

        int[][] res = new int[k][2];
        int index = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            res[index][0] = points[p.index][0];
            res[index][1] = points[p.index][1];
            index++;
        }

        return res;
    }
}
