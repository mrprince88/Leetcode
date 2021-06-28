class Solution {
    public String removeDuplicateLetters(String s) {
        boolean []visited=new boolean[26];
        int []idx=new int[26];
        char []str=s.toCharArray();
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<str.length;i++)
            idx[str[i]-'a']=i;
        
        
        for(int i=0;i<str.length;i++) {
            char curr=str[i];
            
            if(visited[curr-'a']) continue;
            
            while(!stack.isEmpty() && str[stack.peek()]>curr &&
                 idx[str[stack.peek()]-'a']>i) {
                visited[str[stack.peek()]-'a']=false;
                stack.pop();
            }
            stack.push(i);
            visited[curr-'a']=true;
        }
        
        StringBuffer sb=new StringBuffer();
        
        for(int i: stack)
            sb.append(str[i]);
        
        return sb.toString();
    }
}