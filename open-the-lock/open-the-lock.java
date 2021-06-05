class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>(Arrays.asList(deadends));
        
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        int level=0;
        
        while(!q.isEmpty()) {
            int n=q.size();
            
            for(int i=0;i<n;i++) {
                String currentLock = q.poll();
                if (!set.add(currentLock)) continue;
                if (currentLock.equals(target)) return level;
                
                for (String nextLock : getNext(currentLock))
                    if(!set.contains(nextLock)) q.add(nextLock);
            }
            level++;
        }
        return -1;
    }
    
    public List<String> getNext(String s) {
        
        List<String> list=new ArrayList<>();
        char []str=s.toCharArray();
        
        for(int i=0;i<str.length;i++) {
            char c=str[i];
            str[i]=(c=='9') ? '0': (char)(c+1);
            list.add(String.valueOf(str));
            
            str[i]=(c=='0') ? '9': (char)(c-1);
            list.add(String.valueOf(str));
            str[i]=c;
        }
        return list;
    }
}