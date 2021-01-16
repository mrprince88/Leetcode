class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] array = new int[60];
        for (int t : time) {
            array[t % 60] += 1;
        }

        int res = (array[0] * (array[0] - 1)  / 2) + (array[30] * (array[30] - 1) / 2);

        for (int i = 1; i < 30; ++i) {
            res += array[i] * array[60 - i];
        }

        return res;
    }
}