class TreeAncestor {
    Map<Integer, List<Integer>> children = new HashMap<>();
    Integer[][] memo;

    public TreeAncestor(int n, int[] parent) {
        this.memo = new Integer[n][30];
        for (int i = 0; i < n; i++) {
            int curNode = i;
            int parentNode = parent[i];
            children.computeIfAbsent(parentNode, value -> new ArrayList<>()).add(curNode);
            if (i > 0) memo[curNode][0] = parent[i];    //memo[i][j], i is currentNode, j is jth parent from curNode
        }
        dfs(0);
    }
    
    private void dfs(int cur) {
        for (int i = 1; memo[cur][i - 1] != null; i++) {
            int jumptoNextNode = memo[cur][i - 1];
            memo[cur][i] = memo[jumptoNextNode][i - 1];
        }
        for (int child : children.getOrDefault(cur, new ArrayList<>())) 
            dfs(child);
    }
    
    public int getKthAncestor(int node, int k) { 
        for (int i = 0; k > 0; i++) {
            if (k % 2 == 1) { 
                if (memo[node][i] == null) return -1;
                node = memo[node][i];
            } 
            k /= 2;
        } 
       return node; 
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */