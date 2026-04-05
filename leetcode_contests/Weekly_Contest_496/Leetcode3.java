package leetcode_contests.Weekly_Contest_496;

public class Leetcode3 {
    public static long minIncrease(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length - 1; i++) {
            int m = Math.max(nums[i - 1], nums[i + 1]);
            if (nums[i] > m)
                continue;
            ans = Math.min(ans, Math.abs(nums[i] - m) + 1);
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 2};
        // int[] nums = {11,18,11,18};
        int[] nums = { 21, 12, 18, 19 };
        System.out.println(minIncrease(nums));
    }
}
