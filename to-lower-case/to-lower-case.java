class Solution {
    public String toLowerCase(String s) {
        char []str=s.toCharArray();
        
        for(int i=0;i<str.length;i++) {
            if(str[i]>='A' && str[i]<='Z')
                str[i]=(char)(str[i]-'A'+'a');
        }
        return String.valueOf(str);
    }
}