class Solution {
    public int superpalindromesInRange(String left, String right) {
        long L=Long.valueOf(left),R=Long.valueOf(right);
        int ans=0,range=100000;
        
        for(int i=1;i<range;i++) {
            StringBuffer sb=new StringBuffer(String.valueOf(i));
            for(int j=sb.length()-2;j>=0;j--)
                sb.append(sb.charAt(j));
            long v=Long.valueOf(sb.toString());
            v*=v;
            if(v>R) break;
            if(v>=L && isPalindrome(v))
                ++ans;
        }
        
        for(int i=1;i<range;i++) {
            StringBuffer sb=new StringBuffer(String.valueOf(i));
            for(int j=sb.length()-1;j>=0;j--)
                sb.append(sb.charAt(j));
            long v=Long.valueOf(sb.toString());
            v*=v;
            if(v>R) break;
            if(v>=L && isPalindrome(v))
                ++ans;
        }
       return ans;  
    }
    
    private boolean isPalindrome(long a) {
        return a==reverse(a);
    }
    
    private long reverse(long a) {
        long b=0;
        while(a!=0) {
            long r=a%10;
            b=b*10+r;
            a/=10;
        }
        return b;
    }
}