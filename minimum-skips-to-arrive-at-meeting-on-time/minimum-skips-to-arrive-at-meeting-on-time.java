class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n=dist.length;
        
        int []dp=new int[n+1];
        
        for(int i=0;i<n;i++) {
            for(int j=n;j>=0;j--) {
                dp[j]+=dist[i];
                dp[j] = (dp[j]+speed-1) / speed * speed;
                if(j>0)
                    dp[j]=Math.min(dp[j-1]+dist[i],dp[j]);
            }
        }
        
        for(int i=0;i<n;i++)
            if(dp[i]<=(long)speed*hoursBefore)
                return i;
        return -1;
        
    }
}