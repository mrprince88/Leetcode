class Solution {
    
    int[] tree=new int[100002];
    
    int sum(int i) {
        int ans=0;
        for(int j=i;j>0;j-=(j&-j)) ans+=tree[j];
        return ans;
    }
    
    void update(int i) {
        for(int j=i;j<=100001;j+=(j&-j)) tree[j]++;
    }
    
    public int createSortedArray(int[] a) {
        
        int n=a.length;
        int ans=0;
        int mod=(int)(1e9+7);
        
        for(int i=0;i<n;i++) {
            ans+=Math.min(sum(a[i]-1),i-sum(a[i]));
            ans%=mod;
            update(a[i]);
        }
        return ans;
    }
}
