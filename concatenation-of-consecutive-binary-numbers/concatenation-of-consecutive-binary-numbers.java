class Solution {
    public int concatenatedBinary(int n) {
        
        int digits=0,mod=(int)1e9+7;
        long res=0;
        
        for(int i=1;i<=n;i++) {
            if((i&(i-1))==0)
                ++digits;
            res=((res<<digits)+i)%mod;
        }
        return (int)res;
    }
}