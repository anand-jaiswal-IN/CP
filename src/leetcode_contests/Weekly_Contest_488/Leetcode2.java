package leetcode_contests.Weekly_Contest_488;
import java.util.*;

public class Leetcode2 {
    public static long countSubarrays(int[] nums, long k) {
        int ans = nums.length;

        for (int l = 0; l < nums.length; l++) {
            long max = nums[l];
            long min = nums[l];
            for (int r = l + 1; r < nums.length && (r - l + 1) <= k; r++) {
                max = Math.max(max, nums[r]);
                min = Math.min(min, nums[r]);
                if ((max - min) * (r - l + 1) <= k)
                    ans++;
            }
        }
        return ans;
    }

    public static long countSubarrays2(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        int left = 0;

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int right = 0; right < n; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            while (left <= right) {
                long max = nums[maxDeque.peekFirst()];
                long min = nums[minDeque.peekFirst()];

                if ((max - min) * (right - left + 1) <= k) {
                    break;
                }
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }

            ans += (right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int k = 0;
        long r = countSubarrays(nums, k);
        System.out.println(r);

    }
}
