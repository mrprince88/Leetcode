class Solution {
    public int countBinarySubstrings(String s) {
        
        int []g=new int[s.length()];
        int t=0,ans=0;
        g[0]=1;
        
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)!=s.charAt(i-1))
                g[++t]=1;
            else
                g[t]++;
        
        for(int i=1;i<=t;i++)
            ans+=Math.min(g[i],g[i-1]);
            
        return ans;
    }
}