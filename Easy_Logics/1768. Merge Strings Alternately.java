class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1len = word1.length() - 1;
        int w2len = word2.length() - 1;

        int totallen = word1.length() + word2.length(); // Fixed
        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;
        int index = 0;

        while (i <= w1len && j <= w2len) {
            if (index % 2 == 0) { // word1 insert
                ans.append(word1.charAt(i));
                i++;
            } else {
                ans.append(word2.charAt(j));
                j++;
            }
            index++;
        }

        if (i <= w1len) {
            while (index != totallen) {
                ans.append(word1.charAt(i));
                i++;
                index++;
            }
        } else {
            while (index != totallen) {
                ans.append(word2.charAt(j));
                j++;
                index++;
            }
        }

        return ans.toString();
    }
}
