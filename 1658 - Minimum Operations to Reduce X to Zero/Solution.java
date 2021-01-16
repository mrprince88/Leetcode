class Solution {
    public int minOperations(int[] nums, int x) {
        
        int totalSum=0,n=nums.length;
        
        for(int i:nums)
            totalSum+=i;
        
        int target=totalSum-x;
        
        if(target==0)
            return n;
        
        if(target<0)
            return -1;
        
        int maxLength=-1,prefixSum=0,start=0;
        
        for(int i=0;i<n;i++) {
            
            prefixSum+=nums[i];
            
            while(prefixSum>target) {
                prefixSum-=nums[start];
                start++;
            }
            
            if(prefixSum==target) {
                maxLength=Math.max(maxLength,i-start+1);
            }
        }
        
        if(maxLength==-1)
            return -1;
        
        else 
            return n-maxLength;
    }
}
