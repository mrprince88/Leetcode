class Solution {
    public int numDecodings(String s) {
        
        if(s.charAt(0)=='0')
            return 0;
        
        int  n=s.length();
        int dp[]=new int[n+1];
        dp[0]=1; dp[1]=1;
        
        for(int i=1;i<n;i++) {
            
            int c=s.charAt(i);
            int p=s.charAt(i-1);
            
         if (c == '0' && (p == '0' || p > '2'))
            return 0;
            
        if (p == '0')
            dp[i + 1] = dp[i];
            
        else if (p == '1') {
            if (c == '0')
                dp[i + 1] = dp[i - 1];
            else
                dp[i + 1] = dp[i - 1] + dp[i];
        }
            
        else if (p == '2') {
            if (c == '0')
                dp[i + 1] = dp[i - 1];
            else if (c <= '6')
                dp[i + 1] = dp[i] + dp[i - 1];
           else
                dp[i + 1] = dp[i];
        }
            
        else
            dp[i + 1] = dp[i];
 
    }
 
   return dp[s.length()];
 }
}
