class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1=new StringBuffer();
        StringBuffer sb2=new StringBuffer();
        
        for(String i:word1)
            sb1.append(i);
        
        for(String i:word2)
            sb2.append(i);
        
        String s1=sb1.toString();
        String s2=sb2.toString();
        
        return s1.equals(s2);
    }
}