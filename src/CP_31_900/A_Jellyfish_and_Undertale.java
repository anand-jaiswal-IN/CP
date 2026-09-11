// https://codeforces.com/problemset/problem/1875/A

package CP_31_900;

import java.util.*;

public class A_Jellyfish_and_Undertale {
    public static int solution(int a, int b, int[] nums) {
        if (b == 0)
            return 0;
        int i = 1;
        // Arrays.sort(nums);
        int k = 0;
        // b = Math.min(b + nums[k++], a);
        // b--;
        while (b > 0) {
            if (b == 1) {
                if (k >= nums.length)
                    return i;
                b = Math.min(a, b + nums[k++]);
            }
            b--;
            i++;
        }
        return i;
    }

    public static long solution2(long a, long b, long[] nums) {
        long sum = b;
        for (long i : nums) {
            sum += Math.min(i, a - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            int n = sc.nextInt();
            long[] nums = new long[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
            }

            System.out.println(solution2(a, b, nums));
        }
        sc.close();

        // System.out.println(solution(5, 3, new int[] { 1, 1, 7 }));
        // System.out.println(solution2(2, 2, new int[] { 4 ,5, 2 ,2, 5 }));
    }
}
