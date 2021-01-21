class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        int i=0;
        while(i<s.length()) {
            char c=s.charAt(i++);
            if(c=='}' || c==')' || c==']') {
                if(stack.isEmpty())
                    return false;
                else if(stack.peek()=='{' && c=='}')
                    stack.pop();
                else if(stack.peek()=='[' && c==']')
                    stack.pop();
                else if(stack.peek()=='(' && c==')')
                    stack.pop();
                else
                    return false;
            }
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
