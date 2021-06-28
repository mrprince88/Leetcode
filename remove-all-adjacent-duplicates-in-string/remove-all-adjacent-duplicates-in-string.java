class Solution {
    public String removeDuplicates(String s) {
        char []str=s.toCharArray();
        int n=str.length;
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<n;i++) {
            if(!stack.isEmpty() && stack.peek()==str[i]) {
                stack.pop();
            }
            else
                stack.push(str[i]);
        }
        
        StringBuffer sb=new StringBuffer();
        
        for(char i: stack)
            sb.append(i);
        
        return sb.toString();
        
    }
}