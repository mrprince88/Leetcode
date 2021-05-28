class Solution {
    
    int[] solve(int []nums) {
        
        int n=nums.length,point1=-1,point2=-1;
        
        for(int i=n-1;i>0;i--)
            if(nums[i]>nums[i-1]) {
                point1=i-1;
                break;
            }
        
        if(point1==-1)
            reverse(nums,0,n-1);
        
        else {
            for(int i=n-1;i>point1;i--) {
                if(nums[i]>nums[point1]) {
                    point2=i;
                    break;
                }
            }
            
            swap(nums,point1,point2);
            reverse(nums,point1+1,n-1);
        }
        return nums;
    }
    
    void swap(int []nums,int i,int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    void reverse(int []nums,int i,int j) {
        while(i<j) {
            swap(nums,i,j);
            i++;j--;
        }
    }
    public void nextPermutation(int[] nums) {
        solve(nums);
    }
}