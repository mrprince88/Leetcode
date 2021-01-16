class Solution {
	public int[][] generateMatrix(int n) {

		int [][]arr = new int[n][n];
		int startC = 0, endC = n - 1, startR = 0, endR = n - 1, c = 1;

		while (startC <= endC && startR <= endR) {

			for (int i = startC; i <= endC; i++) {
				arr[startR][i] = c++;
			}

			for (int i = startR + 1; i <= endR; i++) {
				arr[i][endC] = c++;
			}

			for (int i = endC - 1; i >= startC; i--) {
				arr[endR][i] = c++;
			}

			for (int i = endR - 1; i > startR; i--) {
				arr[i][startC] = c++;
			}

			startC++;
			startR++;
			endC--;
			endR--;
		}

		return arr;
	}
}