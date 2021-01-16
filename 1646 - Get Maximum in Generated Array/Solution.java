class Solution {
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 0;
        
        int []arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        int ans=1;
        
        for(int i=2;i<=n;i++) {
            if((i&1)==0)
                arr[i]=arr[i/2];
            else
                arr[i]=arr[i/2]+arr[i/2+1];
            ans=Math.max(ans,arr[i]);
        }
        return ans;
    }
}
