package leetcode_contests.Biweekly_Contest_172;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumofThreeNumbersDivisiblebyThree {
    public static int maximumSum(int[] nums) {
        int maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int j2 = j + 1; j2 < nums.length; j2++) {
                    int s = (nums[i] + nums[j] + nums[j2]);
                    if (s % 3 == 0) {
                        maxSum = Math.max(maxSum, s);
                    }
                }
            }
        }
        return maxSum;
    }

    public static int maximumSum2(int[] nums) {
        Arrays.sort(nums);

        ArrayList<Integer> rem0 = new ArrayList<>();
        ArrayList<Integer> rem1 = new ArrayList<>();
        ArrayList<Integer> rem2 = new ArrayList<>();

        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] % 3 == 0)
                rem0.add(nums[i]);
            if (nums[i] % 3 == 1)
                rem1.add(nums[i]);
            if (nums[i] % 3 == 2)
                rem2.add(nums[i]);
        }
        int m = 0;
        if (rem0.size() >= 3)
            m = Math.max(m, rem0.get(0) + rem0.get(1) + rem0.get(2));
        if (rem1.size() >= 3)
            m = Math.max(m, rem1.get(0) + rem1.get(1) + rem1.get(2));
        if (rem2.size() >= 3)
            m = Math.max(m, rem2.get(0) + rem2.get(1) + rem2.get(2));
        if(rem0.size() >= 1 && rem1.size() >= 1 && rem2.size() >= 1)
            m = Math.max(m, rem0.get(0) + rem1.get(0) + rem2.get(0));

        return m;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[] { 4, 2, 3, 1 }));
    }
}
