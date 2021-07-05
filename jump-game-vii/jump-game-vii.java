class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        
        boolean []dp=new boolean[n];
        
        dp[0]=true;
        int prev=0;
        
        for(int i=1;i<n;i++) {
            if(i>=minJump && dp[i-minJump])
                prev++;
            if(i>maxJump && dp[i-maxJump-1])
                prev--;
            dp[i]=prev>0 && s.charAt(i)=='0';
        }
        return dp[n-1];
    }
}