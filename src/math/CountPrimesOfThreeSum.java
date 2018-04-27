package math;

import org.junit.Assert;
import org.junit.Test;

public class CountPrimesOfThreeSum {
    static int MAX = 30000;

    public int countPrimesOfThreeSum(int[] nums){
        int cnt = 0;
        boolean[] isPrime = getPrime(nums);

        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                for (int k = j + 1; k < nums.length; k ++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime[sum]) {
                        cnt ++;
                    }
                }
            }
        }

        return cnt;
    }

    private boolean[] getPrime(int[] nums) {
        boolean[] isPrime = new boolean[MAX];
        for (int i = 2; i < MAX; i ++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < MAX; i ++) {
            if (!isPrime[i]) continue;

            for (int j = i * i; j < MAX; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, countPrimesOfThreeSum(new int[]{1, 2, 4, 6, 7}));
    }
}
