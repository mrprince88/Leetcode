class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int min=0,n=nums.length,max=n-1;
        k=nums.length-k;
        
        while(min<=max) {
            
            int pivot=min,leftIndex=min+1,rightIndex=max;
            
            while(leftIndex<=rightIndex) {
                
                if(nums[leftIndex]>nums[pivot] && nums[rightIndex]<nums[pivot])
                    swap(nums,leftIndex,rightIndex);
                
                if(nums[leftIndex]<=nums[pivot])
                    leftIndex++;
                
                if(nums[rightIndex]>=nums[pivot])
                    rightIndex--;
                
            }
            
            swap(nums,pivot,rightIndex);
            
            if(rightIndex==k) {
                return nums[rightIndex];
            }
            
            else if(rightIndex<k) {
                min=rightIndex+1;
            }
            else if(rightIndex>k) {
                max=rightIndex-1;
            }
        }
        return -1;
    }
    
    void swap(int []nums,int i,int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
