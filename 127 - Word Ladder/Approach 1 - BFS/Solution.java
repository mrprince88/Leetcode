class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words=new HashSet<>(wordList);
        Queue<String> queue= new LinkedList<>();
        words.remove(beginWord);
        queue.add(beginWord);
        int level=0;
        
        while(!queue.isEmpty()) {
            int size=queue.size();
            ++level;
            for(int i=0;i<size;i++) {
                String currWord=queue.poll();
                if(currWord.equals(endWord)) return level;
                List<String> neighbors=neighbors(currWord);
                for(String j:neighbors) {
                    if(words.contains(j)) {
                        words.remove(j);
                        queue.add(j);
                    }
                }
            }
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
