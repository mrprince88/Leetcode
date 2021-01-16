class Solution {
    
    public String longestPalindrome(String str) {
        
        if (str == null || str.length() < 1)
            return "";
        
        int start=0,end=0;
        
        for(int i=0;i<str.length();i++) {
            
            int oddLen=solve(str,i,i);
            int evenLen=solve(str,i,i+1);
            
            int len = Math.max(oddLen, evenLen);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            
        }
        
        return str.substring(start,end+1);
    }
    
    int solve(String str,int pos1,int pos2) {
        
        while(pos1>=0 && pos2<str.length()) {
            
            if(str.charAt(pos1)!=str.charAt(pos2))
                break;
            
            pos1--; pos2++;
        }
        return pos2-pos1-1;
    }
}
