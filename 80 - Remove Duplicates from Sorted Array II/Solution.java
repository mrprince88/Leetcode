class Solution {

    public int removeDuplicates(int[] nums) {

        int o = 0;

        int i = 0;

        while (i < nums.length) {

            int s = i;

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

            int length = i - s + 1;
            int freq = Math.min(length, 2);

            while (freq-- > 0) {
                nums[o] = nums[s];
                o++;
            }
            i++;
        }
        return o;

    }
}