class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length()!=word2.length())
            return false;
        
        int []d1=new int[26];
        int []d2=new int[26];
        
        for(int i=0;i<word1.length();i++) {
            char c=word1.charAt(i);
            d1[c-'a']++;
        }
        
        for(int i=0;i<word2.length();i++) {
            char c=word2.charAt(i);
            d2[c-'a']++;
        }
        
        int res=0;
        
        for(int i=0;i<26;i++) {
            if((d1[i]==0 && d2[i]!=0) || (d2[i]==0 && d1[i]!=0))
                return false;
            res^=d1[i];
            res^=d2[i];
        }
        return res==0;
    }
}
