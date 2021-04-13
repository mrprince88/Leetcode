class Solution {
    public int[] constructArray(int n, int k) {
        int []ans=new int[n];
        int c=0;
        for(int i=1;i<n-k;i++)
            ans[c++]=i;
        for(int i=0;i<=k;i++)
            ans[c++]=(i%2==0) ?(n-k+i/2):(n-i/2);
        return ans;
    }
}