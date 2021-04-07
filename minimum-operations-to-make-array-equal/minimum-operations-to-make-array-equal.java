class Solution {
    public int minOperations(int n) {
        
        int sum=n*(2+(n-1)*2)/2,num=sum/n,c=0;
        
        for(int i=0;i<n;i++) {
            int m=2*i+1;
            if(m>=num)
                break;
            else
                c+=(num-m);
        }
        
        return c;
    }
}