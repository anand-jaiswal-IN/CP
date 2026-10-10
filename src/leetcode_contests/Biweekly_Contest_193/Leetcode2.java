package leetcode_contests.Biweekly_Contest_193;
public class Leetcode2 {
    public int resilientSubarray(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++)
            prefix[i + 1] = prefix[i] + nums[i];
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int last = nums.length - 1;
            while (last >= i) {
                int sum = prefix[last + 1] - prefix[i];
                boolean isBreaked = false;

                for (int j = i; j <= last; j++) {
                    if ((sum - nums[j]) % k != 0) {
                        isBreaked = true;
                        break;
                    }
                }
                if (!isBreaked) {
                    ans = Math.max(ans, last - i + 1);
                }
                last--;
            }
        }
        return ans;
    }
}
