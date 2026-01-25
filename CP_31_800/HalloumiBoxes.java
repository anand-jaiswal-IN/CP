package CP_31_800;
// https://codeforces.com/problemset/problem/1903/A

import java.util.*;

public class HalloumiBoxes {
    public static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // solution starts here
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            
            if ((k == 1 && isSorted(nums)) || k > 1) {
                System.out.println("YES");
            } else
                System.out.println("NO");
            t--;
        }
        sc.close();
    }
}