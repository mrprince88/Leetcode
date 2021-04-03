class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][]dp=new int[m+1][n+1];
        for(String i: strs) {
            int z=0,o=0,c=0;
            for(char j: i.toCharArray()) {
                if(j=='0')
                    z++;
                else
                    o++;
            }
            for(int j = m; j >= z; j--)
                for(int k = n; k >= o; k--)
                    dp[j][k] = Math.max(dp[j][k], dp[j-z][k-o] + 1);
        }
        return dp[m][n];
    }
}