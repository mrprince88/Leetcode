class Solution {
    public int maxScore(int[] a, int k) {
        int n=a.length;
        if(n==1)
            return a[0];
        
        int sum=0;
        
        for(int i=0;i<k;i++)
            sum+=a[i];
        
        int max=sum;
        for(int i=0;i<k;i++) {
            sum=sum-a[k-i-1]+a[n-1-i];
            max=Math.max(max,sum);
        }
        return max;
    }
}
