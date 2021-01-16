class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int i=1,ans=0,x=0;
        
        while(i>=1) {
            if(x<arr.length && arr[x]==i)
                x++;
            else
                ans++;
            if(ans==k)
                break;
            i++;
        }
        return i;
    }
}
