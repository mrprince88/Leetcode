class Solution {
    public String removeKdigits(String num, int k) {
        char []str=num.toCharArray();
        int n=str.length,len=n-k;
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && stack.peek()>str[i] && len-stack.size()<n-i)
                stack.pop();
            stack.push(str[i]);
        }
        
        while(stack.size()>len)
            stack.pop();
        
        if(stack.size()==0)
            return "0";
        
        StringBuffer sb=new StringBuffer();
        for(char i: stack)
            sb.append(i);
        
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}