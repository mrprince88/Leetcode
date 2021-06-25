class Solution {
    public int jump(int[] nums) {
        int n=nums.length,currEnd=0,currFarthest=0,jumps=0;
        
        for(int i=0;i<nums.length-1;i++) {
            currFarthest=Math.max(currFarthest,i+nums[i]);
            
            if(i==currEnd) {
                jumps++;
                currEnd=currFarthest;
            }
        }
        return jumps;
    }
}