class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int ans=0;
        
        for(String i: words)
            if(check(s,i))
                ans++;
        return ans;
    }
    
    
    boolean check(String s1,String s2) {
        int n=s1.length(),m=s2.length();
        
        if(n<m) return false;
        
        int i=0,j=0;
        
        while(i<n && j<m) {
            if(s1.charAt(i)==s2.charAt(j)) {
                int next1=getNext(s1,i),next2=getNext(s2,j);
            
                if(next1<3 && next1!=next2 || next1>=3 && next1<next2) return false;
                i+=next1; j+=next2;
            }
            else return false;
        }
        
        return i==n && j==m;
    }
    
    int getNext(String s,int idx) {
        int i=idx;
        
        while(idx<s.length() && s.charAt(i)==s.charAt(idx))
            idx++;
        
        return idx-i;
    }
}