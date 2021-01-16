class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sqrt = (int) Math.sqrt(target * 2);
        int value = sqrt * (sqrt + 1) / 2;
        
        while (value < target || (value - target) % 2 != 0) {
            value += ++sqrt;
        }
        
        return sqrt;
    }
}
