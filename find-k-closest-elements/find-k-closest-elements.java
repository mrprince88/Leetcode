class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int low=0,high=nums.length-1;
        
        while((high-low)>=k) {
            if(Math.abs(nums[high]-x)>=Math.abs(nums[low]-x))
                high--;
            else
                low++;
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=low;i<=high;i++)
            ans.add(nums[i]);
        
        return ans;
    }
}