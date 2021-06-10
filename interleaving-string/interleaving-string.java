class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n=s1.length(),m=s2.length(),k=s3.length();
        if(n+m!=k)
            return false;
        char []str1=s1.toCharArray(),str2=s2.toCharArray(),str3=s3.toCharArray();
        boolean [][]dp=new boolean[n+1][m+1];
        
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 && j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[i][j]=(dp[i][j-1] && str2[j-1]==str3[j-1]);
                else if(j==0)
                    dp[i][j]=(dp[i-1][j] && str3[i-1]==str1[i-1]);
                else
                    dp[i][j]=(dp[i-1][j] && str3[i+j-1]==str1[i-1]) || (dp[i][j-1] && str3[i+j-1]==str2[j-1]);
                    
            }
        }
        return dp[n][m];
    }
}