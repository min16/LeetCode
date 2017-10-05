package dp;

/**
 * Problem 198
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int ifRobbedPrev = 0;
        int ifNotRobbedPrev = 0;

        for (int i = 0; i < nums.length; i ++) {
            int currRobbed = ifNotRobbedPrev + nums[i];
            int currNotRobbed = Math.max(ifNotRobbedPrev, ifRobbedPrev);

            ifRobbedPrev = currRobbed;
            ifNotRobbedPrev = currNotRobbed;
        }

        return Math.max(ifRobbedPrev, ifNotRobbedPrev);
    }
}
