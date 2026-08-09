class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, "", ans);
        return ans;
    }

    void backtrack(String s, int index, int parts, String curr, List<String> ans) {

        // 4 parts created
        if (parts == 4) {
            if (index == s.length()) {
                ans.add(curr.substring(0, curr.length() - 1));
            }
            return;
        }

        // Try taking 1, 2, or 3 digits
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

            // Leading zero is invalid
            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            // Value must be <= 255
            if (Integer.parseInt(part) > 255)
                break;

            backtrack(
                s,
                index + len,
                parts + 1,
                curr + part + ".",
                ans
            );
        }
    }
}
