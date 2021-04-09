class Solution {
    public List<String> letterCombinations(String digits) {
        
        int n=digits.length();
        List<String> ans=new ArrayList<>();
        
        if(n==0)
            return ans;
        
        String[] ptr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Queue<String> q=new LinkedList<>();
        q.add("");
        
        while(!q.isEmpty()) {
            String s=q.poll();
            if(s.length()==n)
                ans.add(s);
            
            else {
                String v=ptr[Character.getNumericValue(digits.charAt(s.length()))];
                for(int i=0;i<v.length();i++)
                    q.add(s+v.charAt(i));
            }
        }
        
        return ans;
    }
}