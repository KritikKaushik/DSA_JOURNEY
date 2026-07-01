class Pair {
    String s;
    int freq;

    Pair(String s, int freq) {
        this.s = s;
        this.freq = freq;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> wordToFreq = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String insert = words[i];
            wordToFreq.put(insert, wordToFreq.getOrDefault(insert, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq) {
                        return Integer.compare(a.freq, b.freq);
                    }
                    return b.s.compareTo(a.s);// love>i if freq are same
                });

        for (String word : wordToFreq.keySet()) {
            String w = word;
            int freq = wordToFreq.get(w);
            Pair ins = new Pair(w, freq);

            if (pq.size() < k) {
                pq.add(ins);
                continue;
            }
            Pair temp = pq.peek();
            if (temp.freq < ins.freq ||
                    (temp.freq == ins.freq && temp.s.compareTo(ins.s) > 0)) {
                pq.poll();
                pq.add(ins);
            } else {
                continue;
            }
        }
        List<String> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair ans = pq.poll();
            res.add(ans.s);

        }
        Collections.reverse(res);
        return res;
    }
}
