class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
​
        int []arr = new int[k];
        int []minIndices = new int[nums.length];
        minIndices[nums.length - 1] = nums.length - 1;
        int minIndex = nums.length-1;
​
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[minIndex])
                minIndex = i;
            minIndices[i] = minIndex;
        }
​
        int j = 0;
​
        for (int i = 0; i < k; i++) {
            if ((nums.length - minIndices[j]) >= k - i) {
                arr[i] = nums[minIndices[j]];
                j = minIndices[j] + 1;
            } else {
                minIndex = j;
                j++;
                for ( ; j <= nums.length - k + i; j++) {
                    if (nums[j] < nums[minIndex])
                        minIndex = j;
                }
                arr[i] = nums[minIndex];
                j = minIndex + 1;
            }
        }
        return arr;
    }
}
