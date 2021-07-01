class Solution {
    int nums = 0;
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        backTrack(n, ret);
        return ret;
    }
    
    private void backTrack(int n, List<Integer> ret) {
        if (n == 0) {
            ret.add(nums);
            return;
        }
        else {
            backTrack(n - 1, ret);
            nums ^= (1 << n - 1);
            backTrack(n - 1, ret);
        }
    }
    
    
}


// class Solution {
//     public List<Integer> grayCode(int n) {
//         ArrayList arr=new ArrayList<>();
//         for(int i=0;i< 1<<n;i++) arr.add(i^(i>>1));
//         return arr;
//     }
// }