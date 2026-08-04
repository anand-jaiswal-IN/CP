import java.util.Scanner;
import java.util.Arrays;

public class A_Table_with_Numbers {
    public static int solution2(int[] nums, int h, int l) {
        int n = nums.length;
        int countBoth = 0, countRow = 0, countCol = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= h && nums[i] <= l) {
                countBoth++;
            } else if (nums[i] <= h) {
                countRow++;
            } else if (nums[i] <= l) {
                countCol++;
            }
        }

        int ans = Math.min(countCol, countRow);
        int p = (countCol + countRow) - 2 * ans;

        int v = Math.min(p, countBoth);
        ans += v;

        countBoth -= v;
        ans += countBoth / 2;

        return ans;

    }

    public static int solution3(int[] nums, int h, int l) {
        Arrays.sort(nums);

        int i = nums.length - 1;
        int xCount = -1;
        int yCount = -1;

        while (i >= 0) {
            if (nums[i] <= h && xCount == -1) {
                xCount = (i - 0) + 1;
            }
            if (nums[i] <= l && yCount == -1) {
                yCount = (i - 0) + 1;
            }
            i--;
        }
        return Math.min(Math.min(xCount, yCount), Math.max(xCount, yCount) / 2) == -1 ? 0
                : Math.min(Math.min(xCount, yCount), Math.max(xCount, yCount) / 2);
    }

    public static int solution4(int[] nums, int h, int l) {
        int xC = 0, yC = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= h)
                xC++;
            if (nums[i] <= l)
                yC++;
        }

        return Math.min(Math.min(xC, yC), Math.max(xC, yC) / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int h = sc.nextInt();
            int l = sc.nextInt();

            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(solution4(nums, h, l));
        }
        sc.close();
    }

}