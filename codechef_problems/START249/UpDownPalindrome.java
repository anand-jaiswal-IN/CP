package START249;
import java.util.*;

public class UpDownPalindrome {

    public static boolean solution2(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return true;
        if (n <= 3) {
            int f = nums[0];
            int l = nums[n - 1];
            if (Math.abs(f - l) <= 2)
                return true;
            return false;
        }

        for (int i = 0; i < n / 2; i++) {
            int f = nums[i];
            int l = nums[nums.length - 1 - i];

            int[] possibleX = new int[] { -1, -1, -1 }; // range of numbers and any extra element

            int diff = Math.abs(f - l);
            if (diff > 2)
                return false;
            if (diff == 0)
                continue;
            else if (diff == 2) {
                int smaller = Math.min(f, l);
                int left = smaller;
                int right = smaller + 1;
                if (possibleX[0] == -1 && possibleX[1] == -1) {
                    // avi tak possibleX change nh hua hai, hm pehle change krenge
                    possibleX[0] = left;
                    possibleX[1] = right;
                } else {
                    if (!(possibleX[0] <= left && right <= possibleX[1]))
                        return false;
                }
            } else if (diff == 1) {
                int larger = Math.max(f, l);
                int left = larger + 1;
                int right = Integer.MAX_VALUE;
                int extraX = Math.min(f, l);

                if (possibleX[0] == -1 && possibleX[1] == -1) {
                    possibleX[0] = left;
                    possibleX[1] = right;
                    possibleX[2] = extraX;
                } else {

                }
            }
        }
    }

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