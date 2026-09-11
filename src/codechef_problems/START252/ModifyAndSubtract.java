package START252;
import java.util.Scanner;

public class ModifyAndSubtract {
    public static int sol(int[] nums) {
        int n = nums.length;

        long[] D = new long[n + 1];
        D[0] = 0;
        for (int i = 1; i <= n; i++) {
            D[i] = nums[i - 1] - D[i - 1];
        }

        int firstNeg = n + 1;
        for (int i = 1; i < n; i++) {
            if (D[i] < 0) {
                firstNeg = i;
                break;
            }
        }

        long[] E = new long[n + 1];
        for (int k = 1; k < n; k++) {
            if ((n - k) % 2 == 0) {
                E[k] = D[k] - D[n];
            } else {
                E[k] = D[k] + D[n];
            }
        }

        boolean[] validSuffix = new boolean[n + 2];
        validSuffix[n] = true;
        for (int k = n - 1; k >= 1; k--) {
            validSuffix[k] = validSuffix[k + 1] && (E[k] >= 0);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i <= firstNeg && validSuffix[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < nums.length; i++)
                nums[i] = sc.nextInt();

            System.out.println(sol(nums));
        }
        sc.close();
    }

}