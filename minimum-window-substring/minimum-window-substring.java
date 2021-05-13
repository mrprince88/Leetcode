class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()==0 || t.length()==0)
            return "";
        
        HashMap<Character,Integer>map=new HashMap<>();
        
        char []str=s.toCharArray();
        
        for(char i:t.toCharArray())
            map.put(i,map.getOrDefault(i,0)+1);
        
        int i=0,j=0,minLeft=0,minLen=Integer.MAX_VALUE,count=0;
        
        for(j=0;j<str.length;j++) {
            
            if(map.containsKey(str[j])) {
                map.put(str[j],map.get(str[j])-1);
                
            if(map.get(str[j])>=0)
                    ++count;
            while(count==t.length()) {
                
                if(minLen>j-i+1) {
                    minLeft=i;
                    minLen=j-i+1;
                }
            
            if(map.containsKey(str[i])) {
                map.put(str[i],map.get(str[i])+1);
                if(map.get(str[i])>0)
                    count--;
            }
            i++;
            }
        }
        }
        
        if(minLen>str.length)
            return "";
        return s.substring(minLeft,minLeft+minLen);
    }
} 