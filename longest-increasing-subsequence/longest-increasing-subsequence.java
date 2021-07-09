class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> arr=new ArrayList<>();
        arr.add(nums[0]);
        
        for(int i=0;i<n;i++) {
            if(nums[i]>arr.get(arr.size()-1))
                arr.add(nums[i]);
            else {
                int j=binarySearch(arr,nums[i]);
                arr.set(j,nums[i]);
            }
        }
        
        return arr.size();
    }
    
    int binarySearch(List<Integer>arr,int num) {
        int left=0,right=arr.size()-1;
        
        while(left<right)  {
            int mid=(left+right)/2;
            
            if(arr.get(mid)==num)
                return mid;
            
            if(arr.get(mid)<num)
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}