class Solution {
    int []freq1;
    public List<String> wordSubsets(String[] A, String[] B) {
        
        freq1=new int[26];
        List<String> list=new ArrayList<>();
        
        for(String i:B) {
            int []freq=new int[26];
            for(char j:i.toCharArray())
                freq[j-'a']++;
            for(int k=0;k<26;k++)
                freq1[k]=Math.max(freq1[k],freq[k]);
        }
        
        for(String i:A) {
            if(isValid(i))
                list.add(i);
        }
        return list;
    }
    
    boolean isValid(String A) {
        
        int []freq2=new int[26];
        
        for(char i:A.toCharArray())
            freq2[i-'a']++;
        
        for(int i=0;i<26;i++)
            if(freq1[i]>freq2[i])
                return false;
        
        return true;
    }
}