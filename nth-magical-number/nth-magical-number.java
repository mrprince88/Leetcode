class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int A=a,B=b;
        
        while(B>0) {
            int temp=A;
            A=B;
            B=temp%B;
        }
        
        long l=2,r=(long)(1e14),mod=(long)(1e9+7),lcm=a*b/A;
        
        while(l<r) {
           long m=l+(r-l)/2;
            if((m/a) + (m/b) - (m/lcm)<n) l=m+1;
            else r=m;    
        }
        return (int)(l%mod);
    }
}