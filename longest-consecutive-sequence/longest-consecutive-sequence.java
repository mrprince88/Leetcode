class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
            set.add(i);
        
        int largest=0;
        
        for(int i:nums) {
            if(!set.contains(i-1)) {
                int c=0,curr=i;
                
                while(set.contains(curr++))
                    ++c;
                largest=Math.max(largest,c);
            }
        }
        return largest;
    }
}