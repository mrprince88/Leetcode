class Solution {
    public int countVowelStrings(int n) {
        int []dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=5;i++)
            for(int j=1;j<=n;j++)
                dp[j]+=dp[j-1];
        return dp[n];
    }
}