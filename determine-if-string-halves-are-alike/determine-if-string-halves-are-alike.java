class Solution {
    
    boolean isVowel(char c) {
        return c=='a'|| c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='O' || c=='o' || c=='u' || c=='U';
    }
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        
        if(n%2!=0)
            return false;
        
        int a=0,b=0,c=n/2;
        
        for(int i=0;i<c;i++)
            if(isVowel(s.charAt(i)))
                ++a;
        
        for(int i=c;i<n;i++)
            if(isVowel(s.charAt(i)))
                ++b;
        
        return a==b;
    }
}