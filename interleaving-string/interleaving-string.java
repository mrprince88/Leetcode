class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n=s1.length(),m=s2.length(),o=s3.length();
        
        if(o!=n+m)
            return false;
        
        boolean []dp=new boolean[m+1];
        
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 && j==0)
                    dp[j]=true;
                else if(i==0)
                    dp[j]=dp[j-1] && s2.charAt(j-1) ==s3.charAt(i+j-1);
                else if(j==0)
                    dp[j]=dp[j] && s1.charAt(i-1)==s3.charAt(i+j-1);
                else
                    dp[j]=(dp[j-1] && s2.charAt(j-1)==s3.charAt(i+j-1)) || (dp[j] && s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }
        return dp[m];
    }
}