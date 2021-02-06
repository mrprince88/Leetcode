class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        String []dirs=path.split("/");
        
        for(String i: dirs) {
            if(i.equals("")) continue;
            if(i.equals(".")) continue;
            if(i.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else stack.push(i);
        }
        
        return "/"+String.join("/",stack);
    }
}