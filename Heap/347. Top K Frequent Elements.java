class Pair {
    int num;
    int freq;

    Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq) {
                        return Integer.compare(a.freq, b.freq);
                    }
                    return Integer.compare(a.num, b.num);
                });

        for (int n : map.keySet()) {
            int number = n;
            int frequency = map.get(n);
            Pair m = new Pair(number, frequency);
            if (pq.size() < k) {
                pq.add(m);
                continue;
            }
            Pair temp = pq.peek();
            if (pq.size() == k) {

                if (m.freq > temp.freq) {
                    pq.poll();
                    pq.add(m);
                }
            }
            if (m.freq < temp.freq) {
                continue;
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            Pair ans = pq.poll();
            res[index] = ans.num;
            index++;
        }

        return res;

    }
}
