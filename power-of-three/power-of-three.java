class Solution {
    public boolean isPowerOfThree(int n) {
        return (n<=0)? false:1162261467 % n == 0;
    }
}