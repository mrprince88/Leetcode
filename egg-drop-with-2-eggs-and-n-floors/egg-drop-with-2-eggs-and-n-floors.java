class Solution {
    public int twoEggDrop(int n) {
        // x+(x-1)+(x-2)....1<=n
        // x^2+x-2n<=0
        
        int a=1,b=1,c=-2*n;
        
        int d=(b*b)-(4*a*c);
        
        double x=((-1 * b + Math.sqrt(d))/2);
        
        return (int)Math.ceil(x);
    }
}