package START249;
import java.util.*;

public class UpDownPalindrome {

    public static boolean solution(int[] nums) {
        int n = nums.length;
        long lo = Long.MIN_VALUE, hi = Long.MAX_VALUE;

        for (int i = 0; i < n / 2; i++) {
            int f = nums[i];
            int l = nums[n - 1 - i];
            int diff = Math.abs(f - l);

            if (diff == 0)
                continue;
            if (diff != 2)
                return false;

            int smaller = Math.min(f, l);
            lo = Math.max(lo, smaller);
            hi = Math.min(hi, smaller + 1);

            if (lo > hi)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solution(nums) ? "Yes" : "No");
        }
        sc.close();
    }

}