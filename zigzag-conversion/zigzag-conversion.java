class Solution {
    public String convert(String s, int n) {
        
        if(n==1)
            return s;
        
        int len=s.length();
        StringBuffer sb=new StringBuffer();
        int cycleLen=2*(n-1);
        
        for(int i=0;i<n;i++) {
            for(int j=0; j+i<len;j+=cycleLen) {
                sb.append(s.charAt(i+j));
                if(i!=0 && i!=n-1 && j+cycleLen-i<len)
                    sb.append(s.charAt(j+cycleLen-i));
            }
        }
        return sb.toString(); 
    }
}
