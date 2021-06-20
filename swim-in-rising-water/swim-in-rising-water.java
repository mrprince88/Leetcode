class Solution {
    public int swimInWater(int[][] grid) {
        int time = 0;
        int N = grid.length;
        Set<Integer> visited = new HashSet<>();
        while(!visited.contains(N*N-1)) {
            visited.clear();
            dfs(grid, 0, 0, time, visited);
            time++;
        }
        return time - 1;
    }
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    private void dfs(int[][] grid, int i, int j, int time, Set<Integer> visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] > time || visited.contains(i*grid.length+j)) return;
        visited.add(i*grid.length+j);
        for (int[] dir : dirs) {
            dfs(grid, i+dir[0], j+dir[1], time, visited);
        }
    }
}