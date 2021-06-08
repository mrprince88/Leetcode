class Solution {
    public int reverse(int x) {
        
        long s=0;
        
        while(x!=0) {
            int r=x%10;
            s=(s*10)+r;
            x/=10;
        }
        return s>Integer.MAX_VALUE || s<Integer.MIN_VALUE ? 0: (int)s;
    }
}