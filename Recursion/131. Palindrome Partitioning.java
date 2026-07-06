class Solution {
    public boolean isPal(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void help(String s, int n, int index, List<String> dairy, List<List<String>> res) {
        if (index == n) {

            res.add(new ArrayList<>(dairy));

            return;
        }

        for (int i = index; i < n; i++) {
            if (isPal(s, index, i)) {
                dairy.add(s.substring(index, i + 1));
                help(s, n, i + 1, dairy, res);
                dairy.remove(dairy.size() - 1);
            }

        }
    }

    public List<List<String>> partition(String s) {
        List<String> tmp = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        help(s, s.length(), 0, tmp, ans);
        return ans;

    }
}
