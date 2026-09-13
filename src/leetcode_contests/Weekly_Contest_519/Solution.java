package leetcode_contests.Weekly_Contest_519;

import java.util.*;

class Solution {

    // Static lists ensure palindromes are generated only once across all function
    // calls
    private static final List<Long> evenPals = new ArrayList<>();
    private static final List<Long> oddPals = new ArrayList<>();

    static {
        for (int L = 1; L <= 10; L++) {
            int halfLen = (L + 1) / 2;
            long start = (long) Math.pow(10, halfLen - 1);
            long end = (long) Math.pow(10, halfLen);

            for (long i = start; i < end; i++) {
                String s = Long.toString(i);
                StringBuilder sb = new StringBuilder(s);

                // If the palindrome length is odd, do not duplicate the middle digit
                if (L % 2 == 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.reverse();

                long p = Long.parseLong(s + sb.toString());

                // Segregate by parity
                if (p % 2 == 0) {
                    evenPals.add(p);
                } else {
                    oddPals.add(p);
                }
            }
        }
    }

    public long minOperations(int[] nums) {
        long totalOperations = 0;

        for (int x : nums) {
            long target = x;
            if (target % 2 == 0) {
                totalOperations += Math.abs(target - getClosest(target, evenPals)) / 2;
            } else {
                totalOperations += Math.abs(target - getClosest(target, oddPals)) / 2;
            }
        }

        return totalOperations;
    }

    private long getClosest(long target, List<Long> list) {
        int idx = Collections.binarySearch(list, target);

        // Exact match found
        if (idx >= 0) {
            return list.get(idx);
        }

        // Calculate insertion point when exact match is missing
        int insertPoint = -(idx + 1);
        long bestDiff = Long.MAX_VALUE;
        long bestVal = -1;

        // Check the element immediately after the insertion point
        if (insertPoint < list.size()) {
            long val = list.get(insertPoint);
            long diff = val - target;
            if (diff < bestDiff) {
                bestDiff = diff;
                bestVal = val;
            }
        }

        // Check the element immediately before the insertion point
        if (insertPoint > 0) {
            long val = list.get(insertPoint - 1);
            long diff = target - val;
            if (diff <= bestDiff) {
                bestDiff = diff;
                bestVal = val;
            }
        }

        return bestVal;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.minOperations(new int[] { 10, 12, 14, 16 }));
        System.out.println(obj.minOperations(new int[] { 9, 10, 11, 10 }));
        System.out.println(obj.minOperations(new int[] { 125 }));
    }
}
