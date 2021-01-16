class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        while (i < n - 1) {
            if (!(a[i - 1] < a[i] && a[i] > a[i + 1])) { //not a peak
                i++;
                continue;
            }
            int leftIndex = i - 2;
            while (leftIndex >= 0 && a[leftIndex] < a[leftIndex + 1])
                leftIndex--;
            int rightIndex = i + 2;
            while (rightIndex < n && a[rightIndex] < a[rightIndex - 1])
                rightIndex++;
            if (rightIndex + leftIndex == n)
                return true;
        }
        return false;
    }
}