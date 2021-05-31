class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> list=new ArrayList<>();
        int n=searchWord.length();
        
        for(int i=0;i<n;i++) {
            list.add(search(products,searchWord.substring(0,i+1)));
        }
        return list;
    }
    
    boolean check(String a,String b) {
        if(a.length()<b.length())
            return false;
        for(int i=0;i<b.length();i++)
            if(a.charAt(i)!=b.charAt(i))
                return false;
        return true;
    }
    
    List<String> search(String []products,String str) {
        List<String> list=new ArrayList<>();
        for(int i=0;i<products.length;i++) {
            if(check(products[i],str))
                list.add(products[i]);
            if(list.size()==3)
                break;
        }
        return list;
    }
}