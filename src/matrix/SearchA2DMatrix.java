package matrix;
/*
* Problem 74.
* Search a 2D matrix
*/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;

        int low = 0;
        int high = row * col - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int num = matrix[mid / col][mid % col];
            if (num == target) {
                return true;
            } else if (num < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
