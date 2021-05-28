class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> ans=new ArrayList<>();
        
        for(String i: words)
            if(check(i,pattern))
                ans.add(i);
        
        return ans;
    }
    
    boolean check(String word,String pattern) {
        if(pattern.length()!=word.length())
            return false;
        
        int []f1=new int[26]; int []f2=new int[26];
        int n=pattern.length();
        
        for(int i=0;i<n;i++) {
            int idx1=word.charAt(i)-'a',idx2=pattern.charAt(i)-'a';
            f1[idx1]=idx2;
            f2[idx2]=idx1;
        }
               
        for(int i=0;i<n;i++) {
            int idx1=word.charAt(i)-'a',idx2=pattern.charAt(i)-'a';
            if(f1[idx1]!=idx2) return false;
            if(f2[idx2]!=idx1) return false;
        }
        return true;
    }
}