class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int [][]connected=new int[n][n];
        int []cnt=new int[n];
        
        for(int[]road: roads) {
            cnt[road[0]]++;
            cnt[road[1]]++;
            connected[road[0]][road[1]]=1;
            connected[road[1]][road[0]]=1;
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                ans=Math.max(ans,cnt[i]+cnt[j]-connected[i][j]);
        
        return ans;
    }
}