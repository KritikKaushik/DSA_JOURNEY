import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Ideone {

    public static String getSmallestString(String a, int k) {

        if (k == a.length()) {
            return a;
        }

        if (k > a.length()) {
            int in = k - a.length();
            String ad = "";

            for (int i = 0; i < in; i++) {
                ad += "a";
            }

            return ad + a;
        }

        HashMap<Character, Integer> stra = new HashMap<>();
        // Store the original string frequency

        for (int i = 0; i < a.length(); i++) {
            stra.put(a.charAt(i), stra.getOrDefault(a.charAt(i), 0) + 1);
        }

        int unique = stra.size();

        if (unique > k) {
            return "-1";
        }

        StringBuilder prev_String = new StringBuilder();

        for (char ch : stra.keySet()) {
            prev_String.append(ch);
        }

        // Sort initial string
        char[] init = prev_String.toString().toCharArray();
        Arrays.sort(init);
        prev_String = new StringBuilder(new String(init));

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a1, b1) -> {
                if (a1.freq != b1.freq)
                    return b1.freq - a1.freq; // Higher frequency first
                return a1.ch - b1.ch;         // Smaller character first
            });

        // Max heap by frequency

        for (char ch : stra.keySet()) {
            pq.offer(new Pair(ch, stra.get(ch) - 1));
        }

        Pair top = pq.poll();
        int lastFreq = top.freq;
        pq.offer(top);

        StringBuilder checkpoint = new StringBuilder(prev_String);

        int len = unique;

        while (len < k && !pq.isEmpty()) {

            Pair p = pq.poll();

            if (p.freq != lastFreq) {
                lastFreq = p.freq;
                checkpoint = new StringBuilder(prev_String);
            }

            prev_String.append(p.ch);
            len++;

            p.freq--;

            if (p.freq > 0) {
                pq.offer(p);
            }
        }

        // If no frequency change before reaching k,
        // return checkpoint padded with 'a'
        if (checkpoint.length() < k) {
            while (checkpoint.length() < k) {
                checkpoint.append('a');
            }

            char[] arr = checkpoint.toString().toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }

        char[] arr = prev_String.toString().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) throws Exception {

        String a = getSmallestString("abacbca", 4);
        System.out.println(a);

    }
}
