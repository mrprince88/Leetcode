class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        int i,j,k,ans=0,MOD=(int)(1e9+7);
        Arrays.sort(arr);
        
        for(i=0;i<arr.length;i++) {
            
            int t=target-arr[i];
            j=i+1;
            k=arr.length-1;
            
            while(j<k) {
                if(arr[j]+arr[k]<t)
                    j++;
                else if(arr[j]+arr[k]>t)
                    k--;
                
                else if(arr[j]!=arr[k]) {
                    
                    int left=1,right=1;
                    
                    while(j+1<k && arr[j]==arr[j+1]) {
                        left++;
                        j++;
                    }
                    
                    while(k-1>j && arr[k]==arr[k-1]) {
                        right++;
                        k--;
                    }
                    
                    ans+=(left*right);
                    ans%=MOD;
                    j++; k--;  
                }
                
                else {
                    ans+=(k-j+1)*(k-j)/2;
                    ans%=MOD;
                    break;
                }
            }
        } 
        return ans;
    }
}