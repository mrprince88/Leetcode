class Solution {
    public String smallestSubsequence(String s) {
        int []idx=new int[26];
        int []visited=new int[26];
        char []str=s.toCharArray();
        
        for(int i=0;i<str.length;i++)
            idx[str[i]-'a']=i;
        
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<str.length;i++) {
            if(visited[str[i]-'a']==1)
                continue;
            while(!stack.isEmpty() && str[stack.peek()]>str[i] && idx[str[stack.peek()]-'a']>i) {
                visited[str[stack.peek()]-'a']=0;
                stack.pop();
            }
            visited[str[i]-'a']=1;
            stack.push(i);
        }
        
        StringBuffer sb=new StringBuffer();
        for(int i:stack)
            sb.append(str[i]);
        return sb.toString();
    }
}