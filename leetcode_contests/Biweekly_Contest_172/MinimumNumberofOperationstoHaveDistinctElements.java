package leetcode_contests.Biweekly_Contest_172;

import java.util.HashSet;

public class MinimumNumberofOperationstoHaveDistinctElements {

    public static int minOperations2(int[] nums) {
        int n = nums.length;
        int i = 0;

        int ops = 0;

        while (i < n) {
            boolean breaked = false;
            for (int j = i; j < n; j++) {
                for (int j2 = j + 1; j2 < n; j2++) {
                    if (nums[j] == nums[j2]) {
                        ops++;
                        breaked = true;
                        break;
                    }
                }
                if (breaked)
                    break;
            }
            i += 3;
        }
        return ops;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;

        HashSet<Integer> h = new HashSet<>();

        int ops = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (h.contains(nums[i])) {
                int k = (i / 3) + 1;
                ops = Math.max(ops, k);
            } else {
                h.add(nums[i]);
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[] { 3, 8, 3, 6, 5, 8 }));
        System.out.println(minOperations(new int[] { 2, 2 }));
        System.out.println(minOperations(new int[] { 4, 3, 5, 1, 2 }));
        System.out.println(minOperations(new int[] { 35, 92, 99, 99 }));
    }
}
