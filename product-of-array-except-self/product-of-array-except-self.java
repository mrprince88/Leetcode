class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []ans=new int[nums.length];
        Arrays.fill(ans,1);
        int n=nums.length,prev=1;
        for(int i=n-2;i>=0;i--)
            ans[i]=ans[i+1]*nums[i+1];
        
        for(int i=0;i<nums.length;i++) {
            ans[i]*=prev;
            prev=prev*nums[i];
        }
        return ans;
    }
}