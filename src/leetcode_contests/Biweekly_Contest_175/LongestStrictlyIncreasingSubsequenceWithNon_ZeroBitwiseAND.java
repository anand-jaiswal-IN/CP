package leetcode_contests.Biweekly_Contest_175;

import java.util.*;

public class LongestStrictlyIncreasingSubsequenceWithNon_ZeroBitwiseAND {
    public static int longestSubsequence(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int prev = nums[i];
            int ansOps = prev;
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (prev < nums[j] && (ansOps & nums[j]) != 0) {
                    count++;
                    ansOps = ansOps & nums[j];
                    prev = nums[j];
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static int longestSubsequence2(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, helper(nums, nums[i - 1], i, nums[i - 1], 0));
        }
        return ans;
    }


    public static int longestSubsequence3(int[] nums) {
        int best = 0;

        for (int bit = 0; bit < 31; bit++) {
            int flag = 1 << bit;
            List<Integer> seq = new ArrayList<>();

            for (int val : nums) {
                if ((val & flag) == 0) continue;

                int pos = Collections.binarySearch(seq, val);
                if (pos < 0) pos = -pos - 1;

                if (pos < seq.size()) {
                    seq.set(pos, val);
                } else {
                    seq.add(val);
                }
            }

            best = Math.max(best, seq.size());
        }
        return best;
    }

    public static int helper(int[] nums, int prevElement, int idx, int andOps, int ans) {
        if (idx >= nums.length)
            return ans;
        if (prevElement < nums[idx] && (andOps & nums[idx]) != 0) {
            helper(nums, nums[idx], idx + 1, andOps & nums[idx], ans + 1);
        } else {
            helper(nums, prevElement, idx + 1, andOps, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[] nums = { 5, 6, 11 };
        int[] nums = {10,29,13,15,30,29};
        System.out.println(longestSubsequence3(nums));
    }
}
