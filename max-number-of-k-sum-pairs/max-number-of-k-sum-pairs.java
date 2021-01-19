class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        
        for(int i=0;i<nums.length;i++) {
            int target=k-nums[i];
            
            if(map.containsKey(target) && map.get(target)>0) {
                ans++;
                map.put(target,map.get(target)-1);
            }
            
            else {
               int n=map.getOrDefault(nums[i],0);
                n++;
                map.put(nums[i],n);
            }
        }
        return ans;
    }
}
