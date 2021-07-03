class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i=0,j=0,max=0,len=s.length();
        
        Map<Character,Integer> map=new HashMap<>();
        
        while(j<len) {
            char curr=s.charAt(j);
            if(!map.containsKey(curr))
                max=Math.max(max,j-i+1);
            else {
                int last=map.get(curr);
                if(last<i)
                    max=Math.max(max,j-i+1);
                else
                    i=last+1;
            }
            map.put(curr,j++);
        }
        return max;
    }
}