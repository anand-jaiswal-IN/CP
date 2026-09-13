package leetcode_contests.Weekly_Contest_519;

import java.util.*;

public class Leetcode2 {
    public boolean isPalindrome(int n) {
        int ans = 0;
        int nc = n;

        while (nc > 0) {
            int rem = nc % 10;
            ans = (ans * 10) + rem;
            nc /= 10;
        }
        return ans == n;
    }

    int l = 1_000_000 + 1;

    public List<Integer> evenPalindomeNumbers() {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < l; i += 2) {
            if (isPalindrome(i))
                ans.add(i);
        }
        return ans;
    }

    public List<Integer> oddPalindomeNumbers() {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < l; i += 2) {
            if (isPalindrome(i))
                ans.add(i);
        }
        return ans;
    }

    List<Integer> epn, opn;
    boolean isInitialized = false;
    private void init(){
        if(isInitialized) return;
        epn = evenPalindomeNumbers();
        opn = oddPalindomeNumbers();
        isInitialized = true;
    }

    public long minOperations(int[] nums) {
        init();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            List<Integer> list = (x % 2 == 0) ? epn : opn;
            int i1 = lowerBound(list, x);
            int i2 = i1 + 1;

            long best = 0;
            if (i2 >= list.size()) {
                best = (x - list.get(i1)) / 2;
            } else {
                best = Math.min(
                        (x - list.get(i1)) / 2,
                        (list.get(i2) - x) / 2);
            }

            ans += best;

        }

        return ans;
    }

    public int lowerBound(List<Integer> nums, int target) {
        int s = 0, e = nums.size() - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < nums.get(m))
                e = m - 1;
            else
                s = m + 1;
        }
        return e;
    }

    public static void main(String[] args) {
        Leetcode2 obj = new Leetcode2();
        System.out.println(obj.minOperations(new int[] { 10, 12, 14, 16 }));
        System.out.println(obj.minOperations(new int[] { 9, 10, 11, 10 }));
        System.out.println(obj.minOperations(new int[] { 125 }));
        System.out.println(
                obj.minOperations(new int[] { 165, 400, 956, 841, 993, 517, 465, 424, 90, 10, 86, 168, 32, 145, 538 }));
        System.out.println(
                obj.minOperations(new int[] { 35, 47, 48, 59, 42, 19, 68, 3, 3, 47, 43, 64, 92, 2, 11, 87, 15, 26, 32,
                        32, 18, 83, 3, 60, 17, 32, 84, 60, 27, 19, 73, 49, 36, 25, 14, 13, 13, 39, 31, 21, 39, 48 }));
    }
}
