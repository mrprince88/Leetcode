class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        long []dp=new long[n+1];
        int m=(int)(1e9+7);
        
        dp[0]=1; dp[1]= (s.charAt(0)=='*') ? 9: (s.charAt(0)=='0') ? 0:1;
        
        for(int i=1;i<n;i++) {
            if(s.charAt(i)=='*') {
                
                dp[i+1]=9*dp[i] % m;
                
                if(s.charAt(i-1)=='1')
                    dp[i+1]=(dp[i+1]+9*dp[i-1]) % m;
                
                else if(s.charAt(i-1)=='2')
                    dp[i+1]=(dp[i+1]+6*dp[i-1]) % m;
                
                else if(s.charAt(i-1)=='*')
                    dp[i+1]=(dp[i+1]+15*dp[i-1]) % m;
            }
            
            else {
                dp[i+1]=s.charAt(i)=='0' ? 0:dp[i];
                if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6'))
                    dp[i+1]=(dp[i+1]+dp[i-1]) % m;
                
                else if(s.charAt(i-1)=='*')
                    dp[i+1]=(dp[i+1] + (s.charAt(i)<='6' ? 2 : 1) * dp[i-1]) % m;
            }
        }
        return (int)dp[n];
    }
}