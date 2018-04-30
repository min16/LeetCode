package matrix;

import org.junit.Assert;
import org.junit.Test;

/*
* Problem 240.
* Search a 2D Matrix 2
* search from top right
*/

public class SearchA2DMatirx2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;

        int i = 0;
        int j = col - 1;
        while (i < row && j > 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j --;
            } else {
                i ++;
            }
        }

        return false;
    }

    @Test
    public void test() {
        Assert.assertEquals(Boolean.TRUE, searchMatrix(new int[][]{{1, 3, 5}}, 5));
    }
}
