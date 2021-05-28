class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        boolean[] map=new boolean[10001];
        int i=0,j=0,sum=0,ans=-1;
        
        while(i<nums.length && j<nums.length) {
            if(!map[nums[j]]) {
                sum+=nums[j];
                ans=Math.max(ans,sum);
                map[nums[j++]]=true;
            }
            else {
                sum-=nums[i];
                map[nums[i++]]=false;
            }
        }
        return ans;
    }
}