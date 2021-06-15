class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list=new ArrayList<>();
        if(words == null || words.length == 0)  return list;

        HashMap<String,Integer> map=new HashMap<>();
        int n=words.length;
        
        for(int i=0;i<n;i++) map.put(words[i],i);
        
        if(map.containsKey("")) {
            int idx=map.get("");
            for(int i=0;i<n;i++) {
                if(i==idx) continue;
                if(isPalindrome(words[i])) {
                    list.add(Arrays.asList(idx,i));
                    list.add(Arrays.asList(i,idx));
                }
            }
        }
        
        for(int i=0;i<words.length;i++) {
            String rev=reverse(words[i]);
            if(map.containsKey(rev)) {
                int idx=map.get(rev);
                if(idx==i) continue;
                list.add(Arrays.asList(i,idx));
            }
        }
        
        for(int i=0;i<n;i++) {
            String s=words[i];
            
            for(int j=1;j<s.length();j++) {
                if(isPalindrome(s.substring(0,j))) {
                    String rev=reverse(s.substring(j));
                    if(map.containsKey(rev)) {
                        int idx=map.get(rev);
                        list.add(Arrays.asList(idx,i));
                    }
                }
                
                if(isPalindrome(s.substring(j))) {
                    String rev=reverse(s.substring(0,j));
                    if(map.containsKey(rev)) {
                        int idx=map.get(rev);
                        if(idx==i) continue;
                        list.add(Arrays.asList(i,idx));
                    }
                }
            }
        }
        
        return list;
    }
    
    String reverse(String word) {
        StringBuffer sb=new StringBuffer(word);
        return sb.reverse().toString();
    }
    
    boolean isPalindrome(String word) {
        char []arr=word.toCharArray();
        int i=0,j=arr.length-1;
        
        while(i<j) {
            if(arr[i]!=arr[j]) return false;
            i++; j--;
        }
        return true;
    }
}