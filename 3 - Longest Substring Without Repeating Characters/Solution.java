class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i=0,j=0,max=0,len=s.length();
        
        HashSet<Character> h=new HashSet<>();
        
        while(j<len) {
            
            if(h.contains(s.charAt(j))) {
                h.remove(s.charAt(i));
                i++;
            }
            
            else {
                h.add(s.charAt(j));
                j++;
                if(h.size()>max)
                    max++;
                
            }
        }
        return max;
    }
}
