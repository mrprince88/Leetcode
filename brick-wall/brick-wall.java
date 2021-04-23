class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> line : wall) {
            int cur = 0;
            for (int i = 0; i < line.size() - 1; i++) {
                cur += line.get(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        return wall.size() - max;
    }
}