class Solution {
    public int balancedStringSplit(String s) {
        int n=s.length(),ans=0,balance=0;
        
        for(int i=0;i<n;i++) {
            if(balance==0) ans++;
            if(s.charAt(i)=='L')
                balance++;
            else
                balance--;
        }
        return ans;
    }
}