class Solution {

    List<List<String>> list = new ArrayList<>();

    public List<List<String>> partition(String s) {

        helper(s, new ArrayList<String>(), 0);
        return list;
    }

    void helper(String s, List<String> curr, int low) {

        if (low == s.length()) {
            list.add(new ArrayList<>(curr));
            return;
        }

        int n = s.length();

        for (int high = low; high < n; high++) {

            if (isPal(s, low, high)) {

                curr.add(s.substring(low, high + 1));

                helper(s, curr, high + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean isPal(String s, int l, int h) {
        while (l <= h ) {
            if (s.charAt(l) != s.charAt(h))
                return false;
            h--;
            l++;
        }
        return true;
    }
}