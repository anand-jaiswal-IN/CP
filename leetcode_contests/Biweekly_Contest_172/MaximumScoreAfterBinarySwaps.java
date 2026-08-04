package leetcode_contests.Biweekly_Contest_172;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumScoreAfterBinarySwaps {
    public static long maximumScore(int[] nums, String s) {
        int n = nums.length;

        ArrayList<Integer> arrOf1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                arrOf1.add(i);
            }
        }

        if (arrOf1.size() == 0)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
            if (i == arrOf1.get(idx)) {
                ans += pq.poll();
                idx++;
            }
            if (idx == arrOf1.size())
                break;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(maximumScore(new int[] { 2, 1, 5, 2, 3 }, "01010"));
        System.out.println(maximumScore(new int[] { 4, 7, 2, 9 }, "0000"));
        System.out.println(maximumScore(new int[] { 8, 1, 7, 1, 3, 7, 5, 6, 10, 10 },
                "0010111000"));
    }
}
