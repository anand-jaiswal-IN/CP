package leetcode_contests.Biweekly_Contest_176;
import java.util.*;

public class Leetcode3 {
    public long rob(int[] nums, int[] colors) {
        long[] dp = new long[nums.length];
        Arrays.fill(dp, -1);
        return helper(0, nums, colors, dp);
    }

    public long helper(int idx, int[] nums, int[] colors, long[] dp) {
        if (idx >= nums.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        if (idx + 1 < nums.length && colors[idx] == colors[idx + 1]) {
            long take = nums[idx] + helper(idx + 2, nums, colors, dp);
            long skip = helper(idx + 1, nums, colors, dp);
            return dp[idx] = Math.max(take, skip);
        } else {
            long take = nums[idx] + helper(idx + 1, nums, colors, dp);
            long skip = helper(idx + 1, nums, colors, dp);
            return dp[idx] = Math.max(take, skip);
        }

    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };
        int[] colors = { 2, 3, 2, 2 };
        Leetcode3 obj = new Leetcode3();
        long r = obj.rob(nums, colors);
        System.out.println(r);
    }
}
