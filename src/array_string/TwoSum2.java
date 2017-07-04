package array_string;

public class TwoSum2 {
    public static final int NOT_FOUND = -1;

    public int[] twoSumBst(int[] numbers, int target) {
        int size = numbers.length;
        int j;
        for(int i = 0; i < size; i++) {
            j = bSearch(numbers, target - numbers[i], i + 1);
            if(j != NOT_FOUND) {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[2];
    }

    public int[] twoSumPointers(int[] numbers, int target) {
        int size = numbers.length;
        int left = 0, sum;
        int right = size - 1;

        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left +1, right + 1};
            else if (sum < target) left++;
            else right--;
        }
        return new int[2];
    }

    private int bSearch(int[] A, int key, int start) {
        int L = start, R = A.length - 1;
        do {
            int M = (L + R) / 2;
            if (key == A[M]) {
                return M;
            } else if (key > A[M]) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        } while (L <= R);
        return NOT_FOUND;
    }
}
