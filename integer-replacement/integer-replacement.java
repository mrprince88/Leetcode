class Solution {
    public int integerReplacement(int n) {
        if(n==1) return 0;
        if(n==Integer.MAX_VALUE) return 32;
        if((n&1)==0) return 1+ integerReplacement(n/2);
        if(n==3 || Integer.bitCount(n+1)>Integer.bitCount(n-1)) return 1+integerReplacement(n-1);
        return 1+integerReplacement(n+1);
    }
}