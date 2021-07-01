// class Solution {
//     public List<Integer> grayCode(int n) {
        
//     }
// }

class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList arr=new ArrayList<>();
        for(int i=0;i< 1<<n;i++) arr.add(i^(i>>1));
        return arr;
    }
}