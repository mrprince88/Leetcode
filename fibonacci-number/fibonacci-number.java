class Solution {
    public int fib(int n) {
        int a=0,b=1,c=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        while(--n>0) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}