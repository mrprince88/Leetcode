class Solution {
    public String getSmallestString(int n, int k) {
        
        char []ans=new char[n];
        
        Arrays.fill(ans,'a');
        
        int i=n-1;
        k-=n;
        
        while(k>=26) {
            k=k+1-26;
            ans[i]='z';
            i--;
        }
        
        ans[i]=(char)(k+'a');
        return String.valueOf(ans);
    }
}