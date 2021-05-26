class Solution {
    public int evalRPN(String[] tokens) {
        
        if(tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> stack=new Stack<Integer>();
        String s="+/-*";
        
        for(int i=0;i<tokens.length;i++) {
            if(s.contains(tokens[i])) {
                int b=stack.pop(),a=stack.pop();
                if(tokens[i].equals("+")) stack.push(a+b);
                if(tokens[i].equals("-")) stack.push(a-b);
                if(tokens[i].equals("/")) stack.push(a/b);
                if(tokens[i].equals("*")) stack.push(a*b);
            }
            else stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.peek();
    }
}