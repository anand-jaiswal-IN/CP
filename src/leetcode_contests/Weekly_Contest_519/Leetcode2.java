package leetcode_contests.Weekly_Contest_519;

import java.util.*;

public class Leetcode2 {

    static ArrayList<Long> ep;
    static ArrayList<Long> op;
    static boolean initalized = false;

    public void init() {
        ep = new ArrayList<>();
        op = new ArrayList<>();

        initializePalindromes("");

        Collections.sort(ep);
        Collections.sort(op);

        initalized = true;
    }

    public long minOperations(int[] nums) {
        if (!initalized)
            init();

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            long x = (long) nums[i];
            List<Long> list = (x % 2 == 0) ? ep : op;
            int i1 = lowerBound(list, x);
            int i2 = i1 + 1;

            long best = Long.MAX_VALUE;

            if (i1 >= 0) {
                best = Math.min(best, (x - list.get(i1)) / 2);
            }
            if (i2 < list.size()) {
                best = Math.min(best, (list.get(i2) - x) / 2);
            }

            ans += best;
        }

        return ans;
    }

    public int lowerBound(List<Long> nums, long target) {
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

    public void initializePalindromes(String s) {
        if (s.length() >= 5)
            return;

        for (int i = 0; i <= 9; i++) {
            if (s.isEmpty() && i == 0)
                continue;

            StringBuilder base = new StringBuilder(s);
            base.append(i);

            String evenStr = base + new StringBuilder(base).reverse().toString();
            long n1 = Long.parseLong(evenStr);
            if (n1 <= 1_000_000_000L) {
                if (n1 % 2 == 0)
                    ep.add(n1);
                else
                    op.add(n1);
            }
            if (base.length() > 1) {
                String oddStr = base + new StringBuilder(base).reverse().substring(1);
                long n2 = Long.parseLong(oddStr);
                if (n2 <= 1_000_000_000L) {
                    if (n2 % 2 == 0)
                        ep.add(n2);
                    else
                        op.add(n2);
                }
            }
            if (base.length() == 1) {
                if (i % 2 == 0)
                    ep.add((long) i);
                else
                    op.add((long) i);
            }

            initializePalindromes(base.toString());
        }
    }

    public static void main(String[] args) {
        Leetcode2 obj = new Leetcode2();
        System.out.println(obj.minOperations(new int[] { 10, 12, 14, 16 }));
        System.out.println(obj.minOperations(new int[] { 9, 10, 11, 10 }));
        System.out.println(obj.minOperations(new int[] { 125 }));
    }
}