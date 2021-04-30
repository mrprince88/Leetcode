class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int min=0,max=nums.length-1, start=-1,end=-1;
        
        while(min<=max) {
            int mid=min+(max-min)/2;
            
            if(nums[mid]<target)
                min=mid+1;
            
            else if(nums[mid]>target)
                max=mid-1;
            
            else if(nums[mid]==target) {
                start=mid;
                max=mid-1;
            }
        }
        
        min=0; max=nums.length-1;
        
        while(min<=max) {
            int mid=min+(max-min)/2;
            
            if(nums[mid]<target)
                min=mid+1;
            
            else if(nums[mid]>target)
                max=mid-1;
            
            else if(nums[mid]==target) {
                end=mid;
                min=mid+1;
            }
        }
        
        return new int[]{start,end};
    }
}