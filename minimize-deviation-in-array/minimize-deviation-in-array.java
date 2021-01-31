class Solution {
    public int minimumDeviation(int[] nums) {
        
        int n=nums.length;
        TreeSet<Integer> set=new TreeSet<>();
        
        for(int i=0;i<n;i++) {
            if(nums[i]%2==0)
                set.add(nums[i]);
            else
                set.add(nums[i]*2);
        }
        
        int first=set.first(),last=set.last();
        int diff=last-first;
        
        while(last%2==0) {
            set.remove(last);
            set.add(last/2);
            last=set.last();
            first=set.first();
            diff=Math.min(diff,last-first);
        }
        
        return diff;
    }
}