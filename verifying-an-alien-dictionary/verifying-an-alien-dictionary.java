class Solution {
    int dir[];
    public boolean isAlienSorted(String[] words, String order) {
        dir=new int[26];
        
        for(int i=0;i<26;i++) {
            char c=order.charAt(i);
            dir[c-'a']=i;
        }
        
        String word1=words[0];
        int n=words.length;
        
        for(int i=1;i<n;i++) {
            String word2=words[i];
            
            if(compare(word1,word2))
                word1=word2;
            else
                return false;
        }
        return true;
    }
    
    boolean compare(String word1,String word2) {
        
        int n=Math.min(word1.length(),word2.length());
        
        for(int i=0;i<n;i++) {
            char ch1=word1.charAt(i),ch2=word2.charAt(i);
            
            int p1=dir[ch1-'a'],p2=dir[ch2-'a'];
            if(p1==p2)
                continue;
            
            if(p1<p2)
                return true;
            else
                return false;
        }
        return word1.length()<=word2.length();
    }
}