class Solution {
    public List<List<Integer>> generate(int n) {
        
        List<List<Integer>> list=new ArrayList<>();
        list.add(Arrays.asList(1));
        
        for(int i=2;i<=n;i++) {
            List<Integer>arr=new ArrayList<>(i);
            List<Integer> lastList=list.get(list.size()-1);
            for(int j=0;j<i;j++) {
                if(j==0 || j==i-1) {
                    arr.add(1);
                }
                else {
                    arr.add(lastList.get(j-1)+lastList.get(j));
                }
            }
            list.add(arr);
        }
        return list;
    }
}