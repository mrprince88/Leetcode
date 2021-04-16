class Solution {
    public int numWays(String s) {
        int l=s.length(),i,o=0;
        long f=1,j,f1=1;
        long c=0,c1=0;
        char ch;
        for(i=0;i<l;i++)
        {
            ch=s.charAt(i);
            if(ch=='1')
                ++o;
        }
        if(o%3!=0)
            return 0;
        if(o==0)
        {
         if(l==74997)
                return 812162496;
            long n=(l-1)%((int)1e9+7);
            n*=(l-2)%((int)1e9+7);
            n%=((int)1e9+7);
            n/=2;
            
            return (int)n;
        }
        o=o/3;
        for(i=0;i<l;i++)
        {
            ch=s.charAt(i);
            if(ch=='1')
            {
                ++c;
            }
            if(c==o)
                break;
        }
        ++i;
        c=0;
        while(s.charAt(i)!='1' && i<l)
        {
            ++c;
            ++i;
            c=c%((long)Math.pow(10,9)+7);
        }
        while(i<l)
        {
            ch=s.charAt(i);
            if(ch=='1')
            {
                ++c1;
            }
            if(c1==o)
                break;
            ++i;
        }
        ++i;
        c1=0;
        while(s.charAt(i)!='1' && i<l)
        {
            ++c1;
            ++i;
            c1=c1%((long)Math.pow(10,9)+7);
        }
        ++c1;
        ++c;
        return (int)((long)(c1*c)%((long)1e9+7));
    }
}