class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int []nums=new int[n];
        Arrays.fill(nums,1);
        
        for(int i = 1; i < n; i++)
            if(ratings[i] > ratings[i-1])
                nums[i] = nums[i-1]+1;
        
        for(int i=n-1;i>0;i--)
            if(ratings[i-1] > ratings[i])
                nums[i-1] = Math.max(nums[i-1],nums[i]+1);
        
        int res=0;
        
        for(int i: nums)
            res+=i;
        
        return res;
    }
}