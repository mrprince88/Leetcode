class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        for (int y = 0,arr[] = new int[matrix[0].length]; y < matrix.length; y++) {
            MyMap.clear();
            for (int x = 0, sum = 0; x < matrix[0].length; x++) {
                sum += matrix[y][x];
                arr[x] = sum;
                if (arr[x] == target)
                    ans++;
                ans += MyMap.get(arr[x] - target);
                MyMap.inc(arr[x]);
            }
            for (int oy = y + 1, sum = 0; oy < matrix.length; oy++, sum = 0) {
                MyMap.clear();
                for (int x = 0; x < matrix[0].length; x++) {
                    sum += matrix[oy][x];
                    arr[x] += sum;
                    if (arr[x] == target)
                        ans++;
                    ans += MyMap.get(arr[x] - target);
                    MyMap.inc(arr[x]);
                }
            }
        }
        return ans;
    }
}

class MyMap {
    static int[][] arr = new int[1024][3];
    static int gen = 0;
    
    static void clear() {
        gen++;
    }
    
    static void inc(int val) {
        int ind = val;
        while (true) {
            ind &= 1023;
            if (arr[ind][0] != gen) {
                arr[ind][0] = gen;
                arr[ind][1] = val;
                arr[ind][2] = 1;
                return;
            }
            if (arr[ind][1] == val) {
                arr[ind][2]++;
                return;
            }
            ind++;
        }
    }
    
    static int get(int val) {
        int ind = val;
        while (true) {
            ind &= 1023;
            if (arr[ind][0] != gen)
                return 0;
            if (arr[ind][1] == val)
                return arr[ind][2];
            ind++;
        }
    }
}