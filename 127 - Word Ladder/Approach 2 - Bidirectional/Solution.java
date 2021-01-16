class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words=new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        HashSet<String> begin=new HashSet<>();
        HashSet<String> end=new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        int length=1;
        while(!begin.isEmpty() && !end.isEmpty()) {
            if(begin.size()>end.size()) {
                HashSet<String> temp=begin;
                begin=end;
                end=temp;
            }
            HashSet<String> newBegin=new HashSet<>();
            for(String i: begin) {
                List<String> neighbors=neighbors(i);
                for(String j:neighbors) {
                    if(end.contains(j)) return length+1;
                    if(words.contains(j)) {
                        newBegin.add(j);
                        words.remove(j);
                    }
                }
            }
          begin=newBegin;
          length++;
        }
        return 0;  
    }
    
    List<String> neighbors(String s) {
        char[]str=s.toCharArray();
        List<String> list=new ArrayList<>();
        
        for(int i=0;i<str.length;i++) {
            char temp=str[i];
            for(char j='a';j<='z';j++) {
                str[i]=j;
                String neighbor=new String(str);
                list.add(neighbor);
            }
            str[i]=temp;
        }
        return list;
    }
}
